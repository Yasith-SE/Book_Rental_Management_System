package edu.icet.service;

import edu.icet.model.Admin;

public interface AdminSignUpService {

    void addAdminSignUp(Admin admin);

    int getNextAdminId();
}
