package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.Admin;
import edu.icet.repository.AdminSignUpRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminSignUpRepositoryImpl implements AdminSignUpRepository {


    @Override
    public void adminSignUp(Admin admin)throws SQLException {
        String SQL = "INSERT INTO UserAdmin (adminId, adminName, adminRole, adminEmail, adminPassword)" +
                     "VALUES (?, ?, ?, ?, ?)";
        Connection connection =  DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,admin.getAdminId());
        preparedStatement.setObject(2,admin.getAdminName());
        preparedStatement.setObject(3,admin.getAdminRole());
        preparedStatement.setObject(4,admin.getAdminEmail());
        preparedStatement.setObject(5,admin.getAdminPassword());

        preparedStatement.executeUpdate();
    }
    @Override
    public int getNextAdminID() throws SQLException {
        int id = 3;

        String SQL = "SELECT MAX(adminId) FROM userAdmin";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            id = rs.getInt(1) + 1;   // next ID
        }


        return id;
    }

}

