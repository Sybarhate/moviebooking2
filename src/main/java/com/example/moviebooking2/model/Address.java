package com.example.moviebooking2.model;

public class Address {

    private int addressId;
    private String addressLine;
    private int pincode;
    private int stateId;
    private String stateName;
    private int cityId;
    private String cityName;

    public Address() {
    }

    public Address(int address_id, String address_line, int pincode) {
        this.addressId = address_id;
        this.addressLine = address_line;
        this.pincode = pincode;
    }

    public Address(String address_line) {
        this.addressLine = address_line;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
}
