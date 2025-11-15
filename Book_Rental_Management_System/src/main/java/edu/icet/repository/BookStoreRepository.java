package edu.icet.repository;

import edu.icet.model.BookStore;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookStoreRepository {

    ResultSet allBookDetails(BookStore bookStore) throws SQLException;

}
