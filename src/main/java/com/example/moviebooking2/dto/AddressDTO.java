package com.example.moviebooking2.dto;

import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;

public class AddressDTO {

        private String addressId;
        private String addressLine;
        private String pincode;
//        private StateDTO stateId;
        private String stateName;
        private StateDTO state;
        private CityDTO city;
//        private String cityName;

//    public State getState() {
//        return state;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public AddressDTO() {
        }

        public AddressDTO(String address_id, String address_line, String pincode) {
            this.addressId = address_id;
            this.addressLine = address_line;
            this.pincode = pincode;
        }

        public AddressDTO(String address_line) {
            this.addressLine = address_line;
        }

        public String getAddressId() {
            return addressId;
        }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

//    public String getStateId() {
//        return stateId;
//    }
//
//    public void setStateId(String stateId) {
//        this.stateId = stateId;
//    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

//    public String getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(String cityId) {
//        this.cityId = cityId;
//    }
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
}


