package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookStore;
import edu.icet.repository.BookStoreRepository;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookStoreRepositoryImpl implements BookStoreRepository {

    BookStore bookStore =  new BookStore();


    public ResultSet allBookDetails(BookStore bookStore) throws SQLException {
        String SQL = "SELECT * FROM book_registration";
        Connection connection = DBConnection.getInstance().getConnection();

        return (ResultSet) connection .prepareStatement(SQL);
    }

    public void addBooksDetails(BookStore bookStore) throws SQLException {
        String SQL = "INSERT INTO book_registration WHERE VALUE (?,?,?,?,?,?);";

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,bookStore.getBookId());
            preparedStatement.setObject(2,bookStore.getBookTitle());
            preparedStatement.setObject(3,bookStore.getAuthor());
            preparedStatement.setObject(4,bookStore.getCategory());
            preparedStatement.setObject(5,bookStore.getQuantity());
            preparedStatement.setObject(6,bookStore.getPrice());

        preparedStatement.executeUpdate();
    }


}
