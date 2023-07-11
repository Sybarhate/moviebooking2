package com.example.moviebooking2.dao;

import com.example.moviebooking2.dao.DBConnection;
import com.example.moviebooking2.dto.ScreenDTO;
import com.example.moviebooking2.dto.SignUpDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.Cinema;
import com.example.moviebooking2.model.Screen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScreenDao {

    public ScreenDTO addScreenData(ScreenDTO screenDTO) throws DAOException {
        try {

            PreparedStatement statement = null;
            String sql = "insert into screen(cinema_id,name,no_of_rows,no_of_columns) values (?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, Integer.parseInt(screenDTO.getCinemaId()));
            statement.setString(2, screenDTO.getName());
            statement.setInt(3, Integer.parseInt(screenDTO.getNoOfRows()));
            statement.setInt(4, Integer.parseInt(screenDTO.getNoOfColumns()));
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
              screenDTO.setScreenId(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
        return screenDTO;
    }
    public List<Screen> getScreenData(ScreenDTO screenDTO) throws DAOException {
        List<Screen> screens = new ArrayList<>();

        try {

            String sql = "SELECT id,name,no_of_rows,no_of_columns FROM screen where cinema_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(screenDTO.getCinemaId()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Screen screen=new Screen();

                screen.setScreenId(resultSet.getInt(1));
                screen.setName(resultSet.getString(2));
                screen.setNoOfRows(resultSet.getInt(3));
                screen.setNoOfColumns(resultSet.getInt(4));
                screens.add(screen);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving screen details", e);
        }
        return screens;
    }

    public Screen getEditScreenDetails(ScreenDTO screenDTO) throws DAOException {
        Screen screen = new Screen();

        try {
            String sql = "SELECT id,name,no_of_rows,no_of_columns FROM screen where id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(screenDTO.getScreenId()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                screen.setScreenId(resultSet.getInt(1));
                screen.setName(resultSet.getString(2));
                screen.setNoOfRows(resultSet.getInt(3));
                screen.setNoOfColumns(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving screen details", e);
        }
        return screen;
    }
    public void updateScreenDetails(ScreenDTO screenDTO) throws DAOException {
        try {
            String sql = "UPDATE screen SET name=?, no_of_rows=?, no_of_columns=? WHERE id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, screenDTO.getName());
            statement.setInt(2, Integer.parseInt(screenDTO.getNoOfRows()));
            statement.setInt(3, Integer.parseInt(screenDTO.getNoOfColumns()));
            statement.setInt(4, Integer.parseInt(screenDTO.getScreenId()));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error updating screen details", e);
        }
    }


    public void deleteScreen(ScreenDTO screenDTO) throws DAOException {
        try {
            String sql = "DELETE FROM Screen WHERE id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(screenDTO.getScreenId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error deleting screen with ID: ", e);
        }
    }
    public Screen getRowsCols(ScreenDTO screenDTO) throws DAOException {
        Screen screen = new Screen();

        try {
            String sql = "SELECT name,no_of_rows,no_of_columns FROM screen where id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(screenDTO.getScreenId()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                screen.setName(resultSet.getString(1));
                screen.setNoOfRows(resultSet.getInt(2));
                screen.setNoOfColumns(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving screen details", e);
        }
        return screen;
    }
}