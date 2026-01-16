package edu.icet.repository;

import java.sql.SQLException;

public interface RentalItemRepository {

    void saveRentalItem(String rentalId, String bookId, int qty, double price) throws SQLException;
}
