package edu.icet.service.impl;

import edu.icet.model.Admin;
import edu.icet.repository.AdminSignUpRepository;
import edu.icet.repository.impl.AdminSignUpRepositoryImpl;
import edu.icet.service.AdminSignUpService;

import java.sql.SQLException;

public class AdminSignUpServiceImpl implements AdminSignUpService {
    AdminSignUpRepository adminSignUpRepository = new AdminSignUpRepositoryImpl();


    @Override
    public void addAdminSignUp(Admin admin) {
        try {
            adminSignUpRepository.adminSignUp(admin);
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
