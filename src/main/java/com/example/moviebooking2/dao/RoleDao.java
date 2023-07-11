package com.example.moviebooking2.dao;

import com.example.moviebooking2.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    public static List<Role> getRole() {
        List<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT * FROM role";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setRoleId(resultSet.getInt(1));
                role.setRoleName(resultSet.getString(2));
                roles.add(role);
            }
        } catch (Exception e) {
        }
        return roles;
    }

}