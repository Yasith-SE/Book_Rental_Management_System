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
        String sql = "INSERT INTO book_registration(bookId, bookTitle, bookAuthor, category, quantity, price) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,bookStore.getBookId());
            preparedStatement.setObject(2,bookStore.getBookTitle());
            preparedStatement.setObject(3,bookStore.getAuthor());
            preparedStatement.setObject(4,bookStore.getCategory());
            preparedStatement.setObject(5,bookStore.getQuantity());
            preparedStatement.setObject(6,bookStore.getPrice());

        preparedStatement.executeUpdate();
    }

    public boolean exsitsById(String bookID) throws SQLException {
        String SQL = "SELECT 1 FROM book_registration WHERE bookId = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
         preparedStatement.setString(1,bookID);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }

    @Override
    public String generateNextBookId() throws SQLException {

        String sql = "SELECT bookId FROM book_registration ORDER BY bookId DESC LIMIT 1";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String lastId = rs.getString(1);
            return incrementId(lastId);
        } else {
            return "B0002"; // first ID
        }
    }

    private String incrementId(String lastId) {
        int num = Integer.parseInt(lastId.substring(1));
        num++;
        return String.format("B%03d", num);
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
