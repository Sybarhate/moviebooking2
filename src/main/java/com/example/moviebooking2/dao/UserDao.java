package com.example.moviebooking2.dao;

import com.example.moviebooking2.dto.CredentialDTO;
import com.example.moviebooking2.dto.SignUpDTO;
import com.example.moviebooking2.exception.DAOException;
import com.example.moviebooking2.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public User checkUserCredential(CredentialDTO credentialDTO) throws DAOException {
        User user = null;
        try {
            String sql = "select * from user where email_address=? and password=? ";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, credentialDTO.getUserName());
            statement.setString(2, credentialDTO.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setMobileNumber(resultSet.getString(5));
                user.setDateOfBirth(resultSet.getString(6));
                user.setGender(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));
                user.setPassword(resultSet.getString(9));
                user.setVerified(resultSet.getBoolean(11));
                user.setRoleId(resultSet.getInt(12));
                // user.setRole_name(resultSet.getString("role_name"));
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Something Went Wrong", e);

        }
    }

    public SignUpDTO createUser(SignUpDTO signUpDTO) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into user(first_name,last_name,email_address,mobile_number,date_of_birth,gender,address," +
                    "password,verification_code,is_verified,role_id) values (?,?,?,?,?,?,?,?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, signUpDTO.getFirstName());
            statement.setString(2, signUpDTO.getLastName());
            statement.setString(3, signUpDTO.getEmail());
            statement.setString(4, signUpDTO.getMobileNumber());
            statement.setString(5, signUpDTO.getDateOfBirth());
            statement.setString(6, signUpDTO.getGender());
            statement.setString(7, signUpDTO.getAddress());
            statement.setString(8, signUpDTO.getPassword());
            statement.setString(9, signUpDTO.getVerificationCode());
            statement.setBoolean(10, signUpDTO.isVerified());
            statement.setInt(11, Integer.parseInt(signUpDTO.getRoleId()));
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                signUpDTO.setUserId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw new DAOException("Something Went Wrong", ex);
        }
        return signUpDTO;
    }

    public void updateUserIsVerified(boolean isVerified, String email) throws DAOException {
        try {
            String sql = " UPDATE user SET is_verified= ? WHERE  email_address= ?";
            PreparedStatement statement = null;
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setBoolean(1, isVerified);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("something went wrong ", e);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
    }

    public User getUserById(int userId) throws DAOException {
        User user = null;
        try {
            String sql = "select * from user where id=? ";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setMobileNumber(resultSet.getString(5));
                user.setDateOfBirth(resultSet.getString(6));
                user.setGender(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));
                user.setPassword(resultSet.getString(9));
                user.setVerificationCode(resultSet.getString(10));
                user.setVerified(resultSet.getBoolean(11));
                user.setRoleId(resultSet.getInt(12));
                // user.setRole_name(resultSet.getString("role_name"));
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Something Went Wrong", e);

        }
    }
}