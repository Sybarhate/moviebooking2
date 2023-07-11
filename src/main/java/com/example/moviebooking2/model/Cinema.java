package com.example.moviebooking2.model;

public class Cinema {

    private int id;
    private String name;
    private String addressId;
    private int userId;
    private Address address;
    private State state;
    private City city;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Cinema() {
    }

//    public Cinema(int id, String name, Address address, State state, City city) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.state = state;
//        this.city = city;
//    }

    public int getId() {
        return id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


