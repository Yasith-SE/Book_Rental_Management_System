package edu.icet.repository;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;

import java.sql.SQLException;

public interface BookRentalRepository {

    void saveRental(BookRental rental) throws SQLException;
    void saveRentalItem(String rentalId, BookRentalItem item) throws SQLException;
    void updateBookQty(String bookId, int qty) throws SQLException;
}
