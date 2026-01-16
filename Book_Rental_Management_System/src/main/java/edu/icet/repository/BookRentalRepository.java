package edu.icet.repository;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public interface BookRentalRepository {

    void saveRental(Connection con, String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate) throws SQLException;


    void saveRentalItem(Connection con, String rentalId, BookRentalItem item) throws SQLException;

    void updateBookQty(Connection con, String bookId, int qty) throws SQLException;
}
