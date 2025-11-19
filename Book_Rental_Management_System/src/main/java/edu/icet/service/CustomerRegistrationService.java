package edu.icet.service;

import edu.icet.model.CustomerRegistration;
import javafx.collections.ObservableList;

public interface CustomerRegistrationService {

    void addCustomerReg(CustomerRegistration customerRegistration);

    boolean existByNIC(String nic);

    void updateCustomer(CustomerRegistration customerRegistration);

    boolean deleteCustomer(String nic);


    ObservableList<CustomerRegistration> allCustomerResultSet();


}
