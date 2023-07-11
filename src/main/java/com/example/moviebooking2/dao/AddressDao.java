package com.example.moviebooking2.dao;

import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Address;
import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {

    public List<State> getState() throws DAOException {
        List<State> states = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().getDBConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * FROM state");

            while (resultSet.next()) {
                State state = new State();
                state.setStateId(resultSet.getInt(1));
                state.setStateName(resultSet.getString(2));
                states.add(state);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving address details", e);
        }

        return states;
    }

    public List<City> getCity(int stateId) throws DAOException {
        List<City> cities = new ArrayList<>();
        try {
            String sql = "select * FROM city where state_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, stateId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City();
                city.setCityId(resultSet.getInt(1));
                city.setCityName(resultSet.getString(2));
                city.setStateId(resultSet.getInt(3));
                cities.add(city);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving address details", e);
        }

        return cities;
    }


//    public Address getAddress(Cinema cinema) throws DAOException {
//        Address address=new Address();
//        try {
//            String sql = "select * FROM address";
//
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                address.setAddress_id(resultSet.getInt(1));
//            }
//            return address;
//        } catch (SQLException e) {
//            throw new DAOException("Error retrieving  details", e);
//        }
//    }

    public Address addAddress(Address address, int id) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into address(address_line,city_id,pincode) values (?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, address.getAddressLine());
            statement.setInt(2, id);
            statement.setInt(3, address.getPincode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("something went wrong ", ex);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
        return address;
    }

    public Address getAddressId() throws DAOException {
        Address address = new Address();
        try {
            String sql = "SELECT * FROM address";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                address.setAddressId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving Address ID", e);
        }
        return address;
    }
    public Address getAddressIdByCinemaId(int cinemaId) throws DAOException {
        Address address=new Address();
        try {
            String addressIdQuery = "SELECT address_id FROM cinema WHERE id=?";
            PreparedStatement addressIdStatement = DBConnection.getInstance().getDBConnection().prepareStatement(addressIdQuery);
            addressIdStatement.setInt(1, cinemaId);
            ResultSet addressIdResult = addressIdStatement.executeQuery();
            if (addressIdResult.next()) {
                address.setAddressId(addressIdResult.getInt(1));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving Address ID", e);
        }
        return address;
    }
}