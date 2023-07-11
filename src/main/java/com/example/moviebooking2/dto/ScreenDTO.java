package com.example.moviebooking2.dto;

public class ScreenDTO {
    private String screenId;
    private String cinemaId;
    private String noOfRows;
    private String noOfColumns;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(String noOfRows) {
        this.noOfRows = noOfRows;
    }

    public String getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(String noOfColumns) {
        this.noOfColumns = noOfColumns;
    }
}
