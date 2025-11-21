package edu.icet.service;

import edu.icet.model.Employee;

public interface EmployeeSignUpSerivice {

    void addEmployeeSignUp(Employee employee);

    int getNextEmployeeId();


}
