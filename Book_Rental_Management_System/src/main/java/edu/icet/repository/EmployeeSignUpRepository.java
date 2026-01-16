package edu.icet.repository;

import edu.icet.model.Employee;

import java.sql.SQLException;

public interface EmployeeSignUpRepository {

    void employeeSignUp(Employee employee) throws Exception;

    int getNextEmployeeId() throws SQLException;
}
