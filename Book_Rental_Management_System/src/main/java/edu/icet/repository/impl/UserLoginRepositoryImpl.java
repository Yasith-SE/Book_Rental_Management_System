package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.Admin;
import edu.icet.model.Employee;
import edu.icet.model.Users;
import edu.icet.repository.UserLoginRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginRepositoryImpl implements UserLoginRepository {


    @Override
    public void saveAdminLogin(Admin admin) throws SQLException {
        String sql = "INSERT INTO userLogin (username, password, role, accountType) VALUES (?, ?, ?, ?)";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setString(1, admin.getAdminName());
        pst.setString(2, admin.getAdminPassword());
        pst.setString(3, admin.getAdminRole());
        pst.setString(4, "Admin");

        pst.executeUpdate();

    }
    @Override
    public void saveEmployeeLogin(Employee employee)throws SQLException{
        String sql = "INSERT INTO userLogin (username, password, role, accountType) VALUES (?, ?, ?, ?)";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,employee.getEmployeeName());
        preparedStatement.setString(2, employee.getEmployeePassword());
        preparedStatement.setString(3, employee.getEmployeRole());
        preparedStatement.setString(4,"Employee");

        preparedStatement.executeUpdate();
    }
    @Override
    public boolean loginUser(String username, String password, String role) throws SQLException {

        String sql = "SELECT password FROM userLogin WHERE username = ? AND role = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);

        pst.setString(1, username);
        pst.setString(2, role);

        ResultSet rs = pst.executeQuery();

        System.out.println("---------- LOGIN DEBUG START ----------");
        System.out.println("Trying to login: [" + username + "] with Role: [" + role + "]");

        if (rs.next()) {

            String dbHash = rs.getString("password");
            System.out.println("User FOUND in Database!");
            System.out.println("Database Hash: " + dbHash);

            boolean isMatch = BCrypt.checkpw(password, dbHash);

            if (isMatch) {
                System.out.println("PASSWORD MATCH: True. Login should work.");
                System.out.println("---------- LOGIN DEBUG END ----------");
                return true;
            } else {
                System.out.println("PASSWORD MATCH: False.");
                System.out.println("You typed: " + password);
                System.out.println("NOTE: Passwords are Case Sensitive! 'apple' != 'Apple'");
                System.out.println("---------- LOGIN DEBUG END ----------");
                return false;
            }

        } else {

            System.out.println("ERROR: User NOT FOUND in database.");
            System.out.println("Possible causes:");
            System.out.println("1. The Username in DB has a space? e.g., 'Alan ' vs 'Alan'");
            System.out.println("2. The Role in DB doesn't match? e.g., 'clerk' vs 'Clerk'");
            System.out.println("---------- LOGIN DEBUG END ----------");
            return false;
        }
    }
}
