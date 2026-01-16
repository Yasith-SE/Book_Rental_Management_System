package edu.icet.repository;

import edu.icet.model.Admin;
import edu.icet.model.Employee;
import edu.icet.model.Users;

import java.sql.SQLException;

public interface UserLoginRepository {

    void saveAdminLogin(Admin admin) throws SQLException;

    void saveEmployeeLogin(Employee employee)throws SQLException;

    boolean loginUser(String username, String password, String role) throws SQLException;
}
