package edu.icet.DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static DBConnect instance;
    private Connection connection;

    private DBConnect () throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_rental_management_system","root","1234");

    }
    private DBConnect getDbConnection() throws SQLException {
        return null == instance? instance = new DBConnect():instance;


    }
    private Connection getConnection(){
        return connection;

    }

}
