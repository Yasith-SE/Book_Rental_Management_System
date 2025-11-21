package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.Employee;
import edu.icet.repository.EmployeeSignUpRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSignUpRepositoryImpl implements EmployeeSignUpRepository {


    @Override
    public void employeeSignUp(Employee employee) throws Exception {
        String SQL = "INSERT INTO userEmployee (employeeId, employeeName, employeeRole, employeeEmail, employeePassword)" +
                "VALUES (?, ?, ?, ?, ?)";

        Connection connection =  DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,employee.getEmployeeId());
        preparedStatement.setObject(1,employee.getEmployeeName());
        preparedStatement.setObject(2,employee.getEmployeRole());
        preparedStatement.setObject(3,employee.getEmployeeEmailAddress());
        preparedStatement.setObject(4,employee.getEmployeePassword());

        preparedStatement.executeUpdate();

    }
    @Override
    public int getNextEmployeeId() throws SQLException {
        int id = 3;


            String sql = "SELECT MAX(employeeId) FROM userEmployee";

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1) + 1;  // next ID
            }

        return id;
    }
}
