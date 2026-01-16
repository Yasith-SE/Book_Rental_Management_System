package edu.icet.service;

import edu.icet.model.Admin;
import edu.icet.model.Employee;
import edu.icet.model.Users;

public interface UserLoginService {


     void adminLogin(Admin admin);

     void employeeLogin(Employee employee);

     boolean loginUser(String username, String password, String role);
}
