package edu.icet.repository;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;

import java.sql.SQLException;
import java.time.LocalDate;

public interface BookRentalRepository {

    void saveRental(String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate) throws SQLException;
    void saveRentalItem(String rentalId, BookRentalItem item) throws SQLException;
    void updateBookQty(String bookId, int qty) throws SQLException;
}
