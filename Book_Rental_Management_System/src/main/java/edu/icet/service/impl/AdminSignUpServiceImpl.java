package edu.icet.service.impl;

import edu.icet.model.Admin;
import edu.icet.repository.AdminSignUpRepository;
import edu.icet.repository.impl.AdminSignUpRepositoryImpl;
import edu.icet.service.AdminSignUpService;
import edu.icet.service.UserLoginService;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class AdminSignUpServiceImpl implements AdminSignUpService {
    AdminSignUpRepository adminSignUpRepository = new AdminSignUpRepositoryImpl();
    UserLoginService userLoginService = new UserLoginServiceImpl();

    @Override
    public void addAdminSignUp(Admin admin) {
        try {
            String hashPassword = BCrypt.hashpw(admin.getAdminPassword(),BCrypt.gensalt());
            admin.setAdminPassword(hashPassword);

            adminSignUpRepository.adminSignUp(admin);
            userLoginService.adminLogin(admin);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getNextAdminId(){
        try {
            return adminSignUpRepository.getNextAdminID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
