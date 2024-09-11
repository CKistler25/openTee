package com.opentee.model;


public class TeeTime {

    private String time;

    private String courseName;

    private String holes;

    private String price;
    private String bookingUrl;
    private String thumbnailUrl;


    // Default constructor
    public TeeTime() {
    }

    // Custom constructor with all fields


    public TeeTime(String time, String courseName, String holes, String price, String bookingUrl, String thumbnailUrl) {
        this.time = time;
        this.courseName = courseName;
        this.holes = holes;
        this.price = price;
        this.bookingUrl = bookingUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getHoles() {
        return holes;
    }

    public void setHoles(String holes) {
        this.holes = holes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookingUrl() {
        return bookingUrl;
    }

    public void setBookingUrl(String bookingUrl) {
        this.bookingUrl = bookingUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
