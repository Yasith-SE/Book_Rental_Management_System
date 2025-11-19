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

    @Override
    public ResultSet allBookDetails() throws SQLException {
        String SQL = "SELECT * FROM book_registration";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection .prepareStatement(SQL);
        return preparedStatement.executeQuery();
    }
    @Override
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

    public void updateStoreBooks(BookStore bookStore)throws SQLException{

        String SQL = "UPDATE book_registration SET bookTitle = ?, bookAuthor = ?, category = ?, quantity = ? , price = ? WHERE bookId = ? ";
         Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,bookStore.getBookTitle());
        preparedStatement.setObject(2,bookStore.getAuthor());
        preparedStatement.setObject(3,bookStore.getCategory());
        preparedStatement.setObject(4,bookStore.getQuantity());
        preparedStatement.setObject(5,bookStore.getPrice());
        preparedStatement.setObject(6,bookStore.getBookId());

        preparedStatement.executeUpdate();
    }
    public void deleteBook(String bookId) throws SQLException {
        String SQL = "DELETE FROM book_registration WHERE bookId = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, bookId);

        preparedStatement.executeUpdate();
    }


}
