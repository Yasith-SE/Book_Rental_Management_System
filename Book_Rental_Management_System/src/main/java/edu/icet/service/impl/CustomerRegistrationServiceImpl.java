package edu.icet.service.impl;

import edu.icet.model.CustomerRegistration;
import edu.icet.repository.CustomerRegistrationRepository;
import edu.icet.repository.impl.CustomerRegistrationRepositoryImpl;
import edu.icet.service.CustomerRegistrationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {


    CustomerRegistrationRepository customerRegistrationRepository = new CustomerRegistrationRepositoryImpl();

    @Override
    public ObservableList<CustomerRegistration> allCustomerResultSet(){
        ObservableList<CustomerRegistration> customerRegistrations = FXCollections.observableArrayList();

        try {
            ResultSet resultSet = customerRegistrationRepository.allCustomers();

            while (resultSet.next()) {
                customerRegistrations.add(new CustomerRegistration(
                        resultSet.getString("NIC"),
                        resultSet.getString("Name"),
                        resultSet.getObject("DOB", java.time.LocalDate.class),
                        resultSet.getInt("Age"),
                        resultSet.getInt("PhoneNumber"),
                        resultSet.getString("Cust_Email"),
                        resultSet.getString("Cust_HomeAdress")

                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerRegistrations;
    }


    @Override
    public void addCustomerReg(CustomerRegistration customerRegistration) {
        try {
            customerRegistrationRepository.addCustomerReg(customerRegistration);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}






