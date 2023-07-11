package com.example.moviebooking2.model;

public class City {
    private int cityId;
    private String cityName;
    private int stateId;

    public City() {
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
