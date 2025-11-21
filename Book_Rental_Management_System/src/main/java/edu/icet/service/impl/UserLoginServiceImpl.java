package edu.icet.service.impl;

import edu.icet.model.Admin;
import edu.icet.model.Employee;
import edu.icet.model.Users;
import edu.icet.repository.UserLoginRepository;
import edu.icet.repository.impl.UserLoginRepositoryImpl;
import edu.icet.service.UserLoginService;

import java.sql.SQLException;

public class UserLoginServiceImpl implements UserLoginService {

    UserLoginRepository userLoginRepository = new UserLoginRepositoryImpl();

    @Override
    public void adminLogin(Admin admin) {
        try {
            userLoginRepository.saveAdminLogin(admin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void employeeLogin(Employee employee) {
        try {
            userLoginRepository.saveEmployeeLogin(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean loginUser(String username, String password, String role) {
        try {
            return userLoginRepository.loginUser(username,password,role);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
