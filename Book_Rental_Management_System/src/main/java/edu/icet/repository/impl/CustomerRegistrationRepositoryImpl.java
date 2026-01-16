package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.CustomerRegistration;
import edu.icet.repository.CustomerRegistrationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRegistrationRepositoryImpl implements CustomerRegistrationRepository {

    @Override
    public ResultSet allCustomers() throws SQLException {
        String SQL = "SELECT * FROM customer_registration;";

        Connection connect = DBConnection.getInstance().getConnection();
        PreparedStatement preparedCustomerTable = connect.prepareStatement(SQL);
        ResultSet resultSet = preparedCustomerTable.executeQuery();

        return resultSet;
    }

    @Override
    public void addCustomerReg(CustomerRegistration customerRegistration) throws SQLException {
        String SQL ="INSERT INTO customer_registration VALUES(?,?,?,?,?,?,?,?);";

           Connection connection =  DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(SQL);
           preparedStatement.setObject(1,customerRegistration.getNIC());
           preparedStatement.setObject(2,customerRegistration.getFullName());
           preparedStatement.setObject(3,customerRegistration.getDob());
           preparedStatement.setObject(4,customerRegistration.getAge());
           preparedStatement.setObject(5,customerRegistration.getPhoneNo());
           preparedStatement.setObject(6,customerRegistration.getEmailAddress());
           preparedStatement.setObject(7,customerRegistration.getHomeAddress());
           preparedStatement.setObject(8,customerRegistration.getAdultStudent());

           preparedStatement.executeUpdate();


        }
    @Override
    public boolean existsByNIC(String nic) throws SQLException {
        String SQL = "SELECT 1 FROM customer_registration WHERE NIC = ? LIMIT 1";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement(SQL);
        stmt.setString(1, nic);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // true if NIC already exists
    }
    @Override
    public void updateCustomer(CustomerRegistration customerUpdate) throws SQLException {
        String SQL ="UPDATE customer_registration SET Name = ?, DOB = ?, Age = ?, PhoneNumber = ?, Cust_Email = ?, Cust_HomeAdress = ?, Adult_Student = ? WHERE NIC = ?; ";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedUpdateStatement = connection.prepareStatement(SQL);
        preparedUpdateStatement.setObject(1,customerUpdate.getFullName());
        preparedUpdateStatement.setObject(2,customerUpdate.getDob());
        preparedUpdateStatement.setObject(3,customerUpdate.getAge());
        preparedUpdateStatement.setObject(4,customerUpdate.getPhoneNo());
        preparedUpdateStatement.setObject(5,customerUpdate.getEmailAddress());
        preparedUpdateStatement.setObject(6,customerUpdate.getHomeAddress());
        preparedUpdateStatement.setObject(7,customerUpdate.getAdultStudent());

        preparedUpdateStatement.setObject(8,customerUpdate.getNIC());

        preparedUpdateStatement.executeUpdate();

    }

    @Override
    public boolean deleteCustomer(String nic) throws SQLException {
        String SQL="DELETE FROM customer_registration WHERE NIC = ? ;";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement  = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,nic);
        int rowsAffacted =  preparedStatement.executeUpdate();
        preparedStatement.close();

        return rowsAffacted > 0;

    }


}
