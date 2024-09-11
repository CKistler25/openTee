package com.opentee.dao;




import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.opentee.exception.DaoException;
import com.opentee.model.TeeTime;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


@Component
public class JdbcTeeTimeDao implements TeeTimeDao {

    private final JdbcTemplate jdbcTemplate;


    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public JdbcTeeTimeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TeeTime> fetchAllTeeTimes(String date) {



        int day = stripDayFromDate(date);

        int today = LocalDate.now().getDayOfMonth();

        List<TeeTime> teeTimes = new ArrayList<>();


        //Populate list of tee time links

        String sql = "SELECT link_url FROM links";


        String searchQuery;
        List<String> searchUrls = new ArrayList<>();


        try{

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                searchUrls.add(results.getString("link_url"));
            }



        } catch (DaoException e) {
            throw new DaoException(e.getMessage());
        }


                //Loop through links and make Call and then add to tee time object
                try (Playwright playwright = Playwright.create()) {
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true).setTimeout(3000).setSlowMo(300));

                    for (String url : searchUrls) {
                        Page page = browser.newPage(new Browser.NewPageOptions().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/109.0"));
//                        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss");
//                        page.clock().install(new Clock.InstallOptions().setTime(format.parse("2024-09-14T02:00:00")));
                        page.navigate(url);
                        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));


                        // Click the button if it is present
                        page.locator("//button[text()='Public']")
                                .or(page.locator("//button[text()='PUBLIC Online Tee Times']"))
                                .or(page.locator("//button[text()='Public Tee Times']"))
                                .or(page.locator("//button[text()='Online Booking']"))
                                .click();




                        // Wait for the necessary elements to be loaded

                        //page.waitForSelector(".time"); // Replace with actual selector
                        page.waitForLoadState(LoadState.NETWORKIDLE);
                            // Scrape data from the page


                        if(day != today){
                          page.locator("//td[text()='" + day +"']").click();
                          //THINGS THAT DON'T WORK
                          //page.waitForCondition(() -> page.locator(".time").isHidden(), new Page.WaitForConditionOptions().setTimeout(1000));

                            //GENERALLY BAD PRACTICE. NEED A BETTER WAY TO HANDLE THIS
                            page.waitForTimeout(1000);


                        }



                            List<Locator> elements = page.locator(".time").all(); // Replace with actual selector

                            for (Locator element : elements) {
                                TeeTime teeTime = new TeeTime();

                                String time = element.locator(".times-booking-start-time-label").or(element.locator(".booking-start-time-label")).innerText(); // Replace with actual selector
                                String price = element.getByTitle("Green Fee").innerText(); // Replace with actual selector
                                String holes = element.locator(".time-summary-ob-holes-full-text").or(element.locator(".booking-slot-holes"))
                                        .or(element.locator(".time-summary-ob-holes-half-dark").first())
                                        .innerText();
                                //Temp Name
                                //String courseName = element.locator(".times-booking-teesheet-name").or(element.locator("a.navbar-brand")).textContent();// Replace with actual selector
                                String courseName = getCourseNameByUrl(url);
                                teeTime.setTime(time);
                                teeTime.setPrice(price);
                                teeTime.setHoles(holes);
                                teeTime.setBookingUrl(url);
                                teeTime.setCourseName(courseName); // Adjust as needed to extract the actual course name

                                teeTimes.add(teeTime);
                            }

                            System.out.println("Processed URL: " + url);
                            page.close();

                    }


                    browser.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Process the scraped data as needed
                for (TeeTime teeTime : teeTimes) {
                    System.out.println(teeTime.getTime());
                }



                    return teeTimes;








            }


            private String getCourseNameByUrl(String url) {
            String courseName = "";

            String sql = "SELECT course_name FROM courses WHERE course_id = (SELECT course_id FROM links WHERE link_url = ?);";

                try{

                    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, url);
                    if (results.next()) {
                        courseName = results.getString("course_name");
                    }



                } catch (DaoException e) {
                    throw new DaoException(e.getMessage());
                }


            return courseName;
            }






//        String sql = "SELECT player_id, firstname, lastname, jerseynumber, salary, team_id, image_url FROM players";
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//            while  (results.next()) {
//                TeeTime teeTime = mapRowToPlayer(results);
//
//                //this calls private method below to retrieve List<String> positions. Broke out so I can reuse later
//                teeTime.setPositions(retrievePositions(teeTime.getPlayerId()));
//
//                teeTimes.add(teeTime);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }



   private int stripDayFromDate(String date) {
        // Check if the date is in the expected format
        if (date == null || date.length() != 10) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-mm-dd");
        }

        // Split the date string by the hyphen
        String[] parts = date.split("-");


        // Return only the year and month
        int day = Integer.parseInt(parts[2]);

        return day;

    }



    }




//    private HttpEntity<Void> makeAuthEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(headers);
//    }


