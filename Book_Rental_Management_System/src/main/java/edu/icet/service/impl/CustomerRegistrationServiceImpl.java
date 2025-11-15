package edu.icet.service.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.CustomerRegistration;
import edu.icet.repository.CustomerRegistrationRepository;
import edu.icet.repository.impl.CustomerRegistrationRepositoryImpl;
import edu.icet.service.CustomerRegistrationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    CustomerRegistration customerRegistrations = new CustomerRegistration();
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
                        resultSet.getString("Cust_HomeAdress"),
                        resultSet.getString("Adult_Student")

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


    @Override
    public void updateCustomer(CustomerRegistration customerRegistration){
        try {
            customerRegistrationRepository.updateCustomer(customerRegistration);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void deleteCustomer(String nic){
        try {
            customerRegistrationRepository.deleteCustomer(nic);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public boolean checkMemberID(CustomerRegistration memberId){
        boolean memberIdExists = false;

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM customer_registration WHERE NIC='"+memberId+"';");

            String id;
            if (rst.next()){

                id = rst.getString("NIC");
                if(id.equals(Integer.valueOf(String.valueOf(memberId))))
                    memberIdExists = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return memberIdExists;
    }


}






