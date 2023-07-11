package com.example.moviebooking2.dao;

//import com.example.moviebooking2.dto.CinemaDTO;

import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Address;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.City;
import com.example.moviebooking2.model.State;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao {
    private Address address1 = new Address();

    public List<Cinema> getCinemaDetails(int id) throws DAOException {
        List<Cinema> cinemas = new ArrayList<>();
        try {
            String sql = ("SELECT c.id, c.image,c.name, a.address_id, a.address_line, a.pincode, ci.city_id, ci.city_name AS city_name, s.state_id, s.state_name AS state_name\n" +
                    "FROM cinema c\n" +
                    "INNER JOIN address a ON c.address_id = a.address_id\n" +
                    "INNER JOIN city ci ON a.city_id = ci.city_id\n" +
                    "INNER JOIN state s ON ci.state_id = s.state_id\n" +
                    "WHERE c.user_id= ?");
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(resultSet.getInt(1));
                cinema.setImage(resultSet.getString(2));
                cinema.setName(resultSet.getString(3));
                cinema.setAddressId(resultSet.getString(4));
                Address address = new Address(resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6));
                cinema.setAddress(address);

                State state = new State(resultSet.getInt(9), resultSet.getString(10));
                cinema.setState(state);

                City city = new City(resultSet.getInt(7), resultSet.getString(8));
                cinema.setCity(city);
                cinemas.add(cinema);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema details", e);
        }
        return cinemas;
    }

    public void addCinema(Cinema cinema1, int addressId, int userId) throws DAOException {
        try {

            PreparedStatement statement = null;
            String sql = "insert into cinema(image,name,address_id,user_id) values (?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, cinema1.getImage());
            statement.setString(2, cinema1.getName());
            statement.setInt(3, addressId);
            statement.setInt(4, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
    }


    public Cinema getCinemaId(int cinemaId) throws DAOException {
        Cinema cinema = new Cinema();
        try {
            String sql = "select id FROM cinema where user_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, cinemaId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema ID", e);
        }
        return cinema;
    }

    public Cinema getAddressId(int addressId) throws DAOException {
        Cinema cinema = new Cinema();
        try {
            String sql = "select address_id=? FROM cinema where id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, addressId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cinema.setAddressId(String.valueOf(resultSet.getInt(1)));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema ID", e);
        }
        return cinema;
    }

    //
//    public static List<Cinema> getCinemasByCity(int cityId) throws DAOException {
//        List<Cinema> cinemas = new ArrayList<>();
//        try {
//            String sql = "SELECT c.*,a.*,ci.* FROM cinema c LEFT JOIN  movie m ON m.cinema_id = c.id JOIN " +
//                    "address a ON a.address_id=c.address_id JOIN city ci ON ci.city_id=a.city_id" +
//                    " WHERE ci.city_id =? GROUP by c.id;";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setInt(1, cityId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Cinema cinema = new Cinema();
//                cinema.setId(resultSet.getInt("id"));
//                cinema.setName(resultSet.getString("name"));
//                Address address=new Address(resultSet.getString(8));
//                cinema.setAddress(address);
//                City city=new City(resultSet.getInt(13),resultSet.getString(14));
//                cinema.setCity(city);
//                cinemas.add(cinema);
//            }
//        }catch (SQLException e)
//        {
//        }
//        return cinemas;
//    }
//
//}
//



//    public void updateCinema(int cinemaId, String name, String address) throws DAOException {
//        try {
//            // Retrieve address ID
//            String addressIdQuery = "SELECT address_id FROM cinema WHERE id=?";
//            PreparedStatement addressIdStatement = DBConnection.getInstance().getDBConnection().prepareStatement(addressIdQuery);
//            addressIdStatement.setInt(1, cinemaId);
//            ResultSet addressIdResult = addressIdStatement.executeQuery();
//            if (addressIdResult.next()) {
//                address1.setAddressId(addressIdResult.getInt(1));
//            }
//
//            String addressUpdateSql = "UPDATE address SET address_line=? WHERE address_id=?";
//            PreparedStatement preparedStatement = DBConnection.getInstance().getDBConnection().prepareStatement(addressUpdateSql);
//            preparedStatement.setString(1, address);
//            preparedStatement.setInt(2, address1.getAddressId());
//            preparedStatement.executeUpdate();
//
//            //Update cinema table
//            String cinemaUpdateSql = "UPDATE cinema SET name=?, address_id=? WHERE id=?";
//            PreparedStatement preparedState = DBConnection.getInstance().getDBConnection().prepareStatement(cinemaUpdateSql);
//            preparedState.setString(1, name);
//            preparedState.setInt(2, address1.getAddressId());
//            preparedState.setInt(3, cinemaId);
//            preparedState.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new DAOException("Error updating cinema information", e);
//        }
//    }
public void updateCinema(String cinemaImg,int cinemaId, String name, String address) throws DAOException {
    try {
        // Retrieve address ID
        String addressIdQuery = "SELECT address_id FROM cinema WHERE id=?";
        PreparedStatement addressIdStatement = DBConnection.getInstance().getDBConnection().prepareStatement(addressIdQuery);
        addressIdStatement.setInt(1, cinemaId);
        ResultSet addressIdResult = addressIdStatement.executeQuery();
        if (addressIdResult.next()) {
            address1.setAddressId(addressIdResult.getInt(1));
        }

        String addressUpdateSql = "UPDATE address SET address_line=? WHERE address_id=?";
        PreparedStatement preparedStatement = DBConnection.getInstance().getDBConnection().prepareStatement(addressUpdateSql);
        preparedStatement.setString(1, address);
        preparedStatement.setInt(2, address1.getAddressId());
        preparedStatement.executeUpdate();

        //Update cinema table
        String cinemaUpdateSql = "UPDATE cinema SET image=?,name=?, address_id=? WHERE id=?";
        PreparedStatement preparedState = DBConnection.getInstance().getDBConnection().prepareStatement(cinemaUpdateSql);
        preparedState.setString(1, cinemaImg);
        preparedState.setString(2, name);
        preparedState.setInt(3, address1.getAddressId());
        preparedState.setInt(4, cinemaId);
        preparedState.executeUpdate();

//        String cityUpdateSql = "UPDATE address SET city_id=?  WHERE address_id=?";
//        PreparedStatement pcity = DBConnection.getInstance().getDBConnection().prepareStatement(cityUpdateSql);
//        pcity.setString(1, city);
//        pcity.setInt(2, address1.getAddressId());
//        pcity.executeUpdate();

    } catch (SQLException e) {
        throw new DAOException("Error updating cinema information", e);
    }

}

    public void updateCity(int cinemaId,String city) throws DAOException {

        try {
            // Update city table
            String cityUpdateSql = "UPDATE address SET city_id=?  WHERE address_id=?";
        PreparedStatement pcity = DBConnection.getInstance().getDBConnection().prepareStatement(cityUpdateSql);
        pcity.setString(1, city);
        pcity.setInt(2, address1.getAddressId());
        pcity.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error updating city information", e);
        }

    }




























//    public Cinema getCinemaDetails1(int id) throws DAOException {
//        Cinema cinema = new Cinema();
//
//        try {
//            String sql = ("SELECT * from cinema where id=?");
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//
//                cinema.setId(resultSet.getInt(1));
//                cinema.setName(resultSet.getString(2));
//                cinema.setAddressId(resultSet.getString(3));
//                Address address = new Address(resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
//                cinema.setAddress(address);
//
//                State state = new State(resultSet.getInt(8), resultSet.getString(9));
//                cinema.setState(state);
//
//                City city = new City(resultSet.getInt(6), resultSet.getString(7));
//                cinema.setCity(city);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error retrieving cinema details", e);
//        }
//        return cinema;
//    }

    public void deleteCinema(int id) throws DAOException {
        try {
            String sql = "DELETE FROM cinema WHERE id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error deleting cinema with ID: " + id, e);
        }
    }


    public Cinema getEditCinemaDetails(int id) throws DAOException {
        Cinema cinema = null;
        try {
            String sql = ("SELECT c.id, c.image,c.name, a.address_id, a.address_line, a.pincode, ci.city_id, ci.city_name AS city_name, s.state_id, s.state_name AS state_name\n" +
                    "FROM cinema c\n" +
                    "INNER JOIN address a ON c.address_id = a.address_id\n" +
                    "INNER JOIN city ci ON a.city_id = ci.city_id\n" +
                    "INNER JOIN state s ON ci.state_id = s.state_id\n" +
                    "WHERE c.id= ?");
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cinema = new Cinema();
                cinema.setId(resultSet.getInt(1));
                cinema.setImage(resultSet.getString(2));
                cinema.setName(resultSet.getString(3));
                cinema.setAddressId(resultSet.getString(4));

                Address address = new Address(resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6));
                cinema.setAddress(address);

                State state = new State(resultSet.getInt(9), resultSet.getString(10));
                cinema.setState(state);

                City city = new City(resultSet.getInt(7), resultSet.getString(8));
                cinema.setCity(city);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema details", e);
        }
        return cinema;
    }

}

