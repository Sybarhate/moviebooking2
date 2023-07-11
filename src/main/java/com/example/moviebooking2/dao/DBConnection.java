package com.example.moviebooking2.dao;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends HttpServlet {

    private static DBConnection dbConnection = new DBConnection();
    private Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/project";
    String username = "root";
    String password = "";

    private DBConnection() {

    }

    public static DBConnection getInstance() {
        return dbConnection;
    }

    public Connection getDBConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}



