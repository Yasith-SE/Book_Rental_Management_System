package edu.icet.service.impl;

import edu.icet.model.Employee;
import edu.icet.repository.EmployeeSignUpRepository;
import edu.icet.repository.impl.EmployeeSignUpRepositoryImpl;
import edu.icet.service.EmployeeSignUpSerivice;

import java.sql.SQLException;

public class EmployeeSignUpServiceImpl implements EmployeeSignUpSerivice {
    EmployeeSignUpRepository employeeSignUpRepository = new EmployeeSignUpRepositoryImpl();

    @Override
    public void addEmployeeSignUp(Employee employee) {

        try {
            employeeSignUpRepository.employeeSignUp(employee);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNextEmployeeId() {
        try {
            return employeeSignUpRepository.getNextEmployeeId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
