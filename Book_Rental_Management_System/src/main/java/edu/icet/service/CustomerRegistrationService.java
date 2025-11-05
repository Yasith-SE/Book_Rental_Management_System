package edu.icet.service;

import edu.icet.model.CustomerRegistration;
import javafx.collections.ObservableList;

public interface CustomerRegistrationService {

    void addCustomerReg(CustomerRegistration customerRegistration);

    void updateCustomer(CustomerRegistration customerRegistration);

    ObservableList<CustomerRegistration> allCustomerResultSet();

}
