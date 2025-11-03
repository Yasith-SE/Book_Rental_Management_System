package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnect;
import edu.icet.model.CustomerRegistration;
import edu.icet.repository.CustomerRegistrationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRegistrationRepositoryImpl implements CustomerRegistrationRepository {

    public void addCustomerReg(CustomerRegistration customerRegistration) throws SQLException {
        String SQL ="INSERT INTO customer_registration VALUES(?,?,?,?,?,?,?);";

           Connection connection =  DBConnect.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SQL);
           preparedStatement.setObject(1,customerRegistration.getNIC());
           preparedStatement.setObject(2,customerRegistration.getFullName());
           preparedStatement.setObject(3,customerRegistration.getDob());
           preparedStatement.setObject(4,customerRegistration.getAge());
           preparedStatement.setObject(5,customerRegistration.getPhoneNo());
           preparedStatement.setObject(6,customerRegistration.getEmailAddress());
           preparedStatement.setObject(7,customerRegistration.getHomeAddress());

           preparedStatement.executeUpdate();

        }





}
