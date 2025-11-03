package edu.icet.repository;

import edu.icet.model.CustomerRegistration;

import java.sql.SQLException;

public interface CustomerRegistrationRepository {

    void addCustomerReg(CustomerRegistration customerRegistration) throws SQLException;

}
