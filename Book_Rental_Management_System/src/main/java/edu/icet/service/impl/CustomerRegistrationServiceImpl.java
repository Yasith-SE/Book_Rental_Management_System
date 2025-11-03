package edu.icet.service.impl;

import edu.icet.model.CustomerRegistration;
import edu.icet.repository.CustomerRegistrationRepository;
import edu.icet.repository.impl.CustomerRegistrationRepositoryImpl;
import edu.icet.service.CustomerRegistrationService;

import java.sql.SQLException;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    CustomerRegistrationRepository customerRegistrationRepository = new CustomerRegistrationRepositoryImpl();

    public void addCustomer(CustomerRegistration customerRegistration){

        try {
            customerRegistrationRepository.addCustomerReg(customerRegistration);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
