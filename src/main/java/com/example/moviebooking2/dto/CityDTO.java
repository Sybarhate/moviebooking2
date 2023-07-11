package com.example.moviebooking2.dto;

public class CityDTO {
    private String cityId;
    private String cityName;
    private String stateId;

    public CityDTO() {
    }

    public CityDTO(String cityId) {
        this.cityId = cityId;
    }

    public CityDTO(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
}
