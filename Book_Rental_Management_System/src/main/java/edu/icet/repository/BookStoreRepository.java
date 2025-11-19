package edu.icet.repository;

import edu.icet.model.BookStore;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookStoreRepository {

    ResultSet allBookDetails() throws SQLException;

    void addBooksDetails(BookStore bookStore) throws SQLException;

    void updateStoreBooks(BookStore bookStore)throws SQLException;

    void deleteBook(String bookId) throws SQLException;
}
