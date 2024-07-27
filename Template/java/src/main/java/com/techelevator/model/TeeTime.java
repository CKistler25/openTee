package com.techelevator.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TeeTime {

    private int teeTimeId;    // player id is the internal id (emp id) NOT jersey number
    @NotBlank(message = "You need to include a courseName you big dummy")
    private String courseName;
    @NotBlank(message = "You need to include a time you big dummy")
    private LocalDateTime time;
    private int availablePlayers;


    public TeeTime() {

    }

    public TeeTime(int teeTimeId, String courseName, LocalDateTime time, int availablePlayers) {
        this.teeTimeId = teeTimeId;
        this.courseName = courseName;
        this.time = time;
        this.availablePlayers = availablePlayers;
    }



    public int getTeeTimeId() {
        return teeTimeId;
    }

    public void setTeeTimeId(int teeTimeId) {
        this.teeTimeId = teeTimeId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getAvailablePlayers() {
        return availablePlayers;
    }

    public void setAvailablePlayers(int availablePlayers) {
        this.availablePlayers = availablePlayers;
    }
}
