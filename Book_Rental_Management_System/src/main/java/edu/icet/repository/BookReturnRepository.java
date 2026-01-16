package edu.icet.repository;

import edu.icet.model.BookReturn;

import java.sql.SQLException;

public interface BookReturnRepository {

    BookReturn findRentalById(String rentalId) throws SQLException;

    boolean saveReturn(BookReturn bookReturn) throws SQLException;

}
