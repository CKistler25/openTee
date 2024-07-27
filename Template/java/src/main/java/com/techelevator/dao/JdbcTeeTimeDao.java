package com.techelevator.dao;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techelevator.exception.DaoException;
import com.techelevator.model.TeeTime;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class JdbcTeeTimeDao implements TeeTimeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTeeTimeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TeeTime> fetchAllTeeTimes() {

        List<TeeTime> teeTimes = new ArrayList<>();

        String searchQuery;
        List<String> searchUrls = new ArrayList<>();




        try{

            for(String url : searchUrls){
                WebClient client = new WebClient();
                HtmlPage page = client.getPage(url);







            }





        } catch (IOException e) {
            throw new RuntimeException(e);
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
        return teeTimes;
    }

    @Override
    public TeeTime fetchPlayerByPlayerId(int playerId) {
        return null;
    }

    @Override
    public TeeTime fetchTeeTimes() {

        TeeTime teeTime = null;
        String sql = "SELECT player_id, firstname, lastname, jerseynumber, salary, team_id, image_url FROM players " +
                     " WHERE player_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);

            if  (results.next()) {
                 teeTime = mapRowToPlayer(results);

                //this calls private method below to retrieve List<String> positions. Broke out so I can reuse later
                teeTime.setPositions(retrievePositions(teeTime.getPlayerId()));

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return teeTime;
    }

    @Override
    public TeeTime addPLayer(TeeTime newTeeTime) {

        //insert into players table
        String player_table_sql = "INSERT INTO players (firstname, lastname, jerseynumber, salary, team_id, image_url) VALUES (?, ?, ?, ?, ?, ?) RETURNING player_id";
        int new_id = jdbcTemplate.queryForObject(player_table_sql, int.class, newTeeTime.getFirstName(), newTeeTime.getLastName(), newTeeTime.getJerseyNumber(), newTeeTime.getSalary(), newTeeTime.getTeamId(), newTeeTime.getImageUrl());
        newTeeTime.setPlayerId(new_id);

        //insert into positions table
        //TODO (Lot of work so skipping. We need to make sure the front end picks from a list )

        //insert into player_position table
        //TODO



        return newTeeTime;
    }

    @Override
    public TeeTime updatePlayer(TeeTime updatedTeeTime) {
        String sql = "UPDATE players SET firstname = ?, lastname = ?, jerseynumber = ?, salary = ?, team_id = ? " +
                     "WHERE player_id = ?";

        int rowCount = jdbcTemplate.update(sql, updatedTeeTime.getFirstName(), updatedTeeTime.getLastName(), updatedTeeTime.getJerseyNumber(), updatedTeeTime.getSalary(), updatedTeeTime.getTeamId(), updatedTeeTime.getPlayerId());

        if (rowCount < 1) {
            throw new DaoException("Error. Player was not updated.");
        }
        return updatedTeeTime;
    }

    @Override
    public void deletePlayer(int playerId){

        //TODO Handle exceptions properly...

        // SQL TO REMOVE FROM JOIN TABLE AND PLAYER TABLE
        String sql2 = "DELETE FROM player_position WHERE player_id = ?";
        String sql3 = "DELETE FROM players WHERE player_id = ?";

        jdbcTemplate.update(sql2, playerId);
        jdbcTemplate.update(sql3, playerId);

    }



    private TeeTime mapScrapeToTeeTime() {
        TeeTime teeTime = new TeeTime();
        teeTime.setTeeTimeId(0);
        teeTime.setCourseName(null);
        teeTime.setTime(null);
        return teeTime;
    }

    private List<String> retrievePositions(int playerId) {
        List<String> positions = new ArrayList<>();

        String sql = "SELECT positions.positionName FROM player_position " +
                "JOIN positions ON player_position.position_id = positions.position_id " +
                "WHERE player_id = ?";
        SqlRowSet pos_results = jdbcTemplate.queryForRowSet(sql, playerId);

        while (pos_results.next()) {
            positions.add(pos_results.getString("positionName"));
        }

        return positions;
    }

}
