package com.example.moviebooking2.service;

import com.example.moviebooking2.dao.AddressDao;
import com.example.moviebooking2.dao.CinemaDao;
import com.example.moviebooking2.dto.AddressDTO;
import com.example.moviebooking2.dto.CityDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Address;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;

import java.util.List;

public class CinemaService {
    private CinemaDao cinemaDao = new CinemaDao();
    private AddressDao addressDao = new AddressDao();

    public List<State> getStateDetails() throws DAOException {
        List<State> stateList = addressDao.getState();
        return stateList;
    }

    public List<City> getCityDetails(int stateId) throws DAOException {
        List<City> cityList = addressDao.getCity(stateId);
        return cityList;
    }

    public void addAddressDetails(Address address, int cityId) throws DAOException {
        addressDao.addAddress(address, cityId);
    }

    public Address getAddressID() throws DAOException {
        Address address = addressDao.getAddressId();
        return address;
    }

    public CinemaDao addCinemaDetails(Cinema cinema, int addressId, int id) throws DAOException {
        cinemaDao.addCinema(cinema, addressId, id);
        return cinemaDao;
    }

    public Cinema updateCityState(String city, String state) {

        return null;
    }

    public Address getAddressId(int cinemaId) throws DAOException {
            AddressDao addressDao=new AddressDao();
            Address address =addressDao.getAddressIdByCinemaId(cinemaId);
            return address;
        }


}


