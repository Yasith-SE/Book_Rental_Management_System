package edu.icet.service;

import edu.icet.model.CustomerRegistration;
import javafx.collections.ObservableList;

public interface CustomerRegistrationService {

    void addCustomerReg(CustomerRegistration customerRegistration);

    boolean checkMemberID(CustomerRegistration memberId);

    void updateCustomer(CustomerRegistration customerRegistration);

    void deleteCustomer(String nic);


    ObservableList<CustomerRegistration> allCustomerResultSet();


}
