package edu.icet.repository;

import edu.icet.model.Admin;

import java.sql.SQLException;

public interface AdminSignUpRepository {

    void adminSignUp(Admin admin) throws SQLException;

    int getNextAdminID() throws SQLException;
}
