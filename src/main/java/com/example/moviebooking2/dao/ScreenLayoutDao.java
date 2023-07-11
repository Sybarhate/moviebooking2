package com.example.moviebooking2.dao;

import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.ScreenLayout;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreenLayoutDao {

    public static void storeSeatNumbers(String screenId, List<String> seatNumbers) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "INSERT INTO screenlayout (screen_id,seat_number) VALUES (?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            for (String seatNumber : seatNumbers) {
                statement.setInt(1, Integer.parseInt(screenId));
                statement.setString(2, seatNumber);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException("Error while storing seat numbers:", e);
        }
    }

    public static List<ScreenLayout> fetchSeatNumbersFromDatabase(String screenid) throws DAOException {
        List<ScreenLayout> seatNumbers = new ArrayList<>();

        try {

            String sql = "SELECT seat_number FROM screenlayout where screen_id=? ";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(screenid));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ScreenLayout screenLayout = new ScreenLayout();
                screenLayout.setSeatNumber(resultSet.getString("seat_number"));
                seatNumbers.add(screenLayout);
            }

        } catch (SQLException e) {
            throw new DAOException("Error while fetching seat numbers: " + e);
        }
        return seatNumbers;
    }

//
//    public ScreenLayout getSeatStatus(int screenId,String seatNumber) throws DAOException {
//        ScreenLayout screenLayout = new ScreenLayout();
//        try
//        {
//            String sql="select status from screenLayout where screen_id=? and seat_number=?";
//            PreparedStatement statement=DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setInt(1, screenId);
//            statement.setString(2, seatNumber);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                screenLayout.setStatus(resultSet.getString("status"));
//            }
//
//        }catch (SQLException e)
//        {
//            throw new DAOException("Error while fetching status");
//        }
//        return screenLayout;
//    }
//
//    public void updateSeatStatus(String seatNumber,ScreenLayout screenLayout, int screenId) throws DAOException {
//        try {
//            String sql = "UPDATE screenlayout SET status =? WHERE screen_id=? and seat_number =?";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setString(1, screenLayout.getStatus());
//            statement.setInt(2, screenId);
//            statement.setString(3, seatNumber);
//
//           // System.out.println("status"+ screenLayout.getStatus());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DAOException("Error while updating seat status in the database",e);
//        }
//    }


}
