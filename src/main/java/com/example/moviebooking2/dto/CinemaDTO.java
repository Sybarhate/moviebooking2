package com.example.moviebooking2.dto;

import com.example.moviebooking2.model.Address;
import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;

public class CinemaDTO {
    private String id;
    private String name;
    private String addressId;
    private String userId;
    private AddressDTO address;
    private StateDTO state;
    private CityDTO city;

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

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

    public CinemaDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}