package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.repository.RentalItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalItemRepositoryImpl implements RentalItemRepository {
    @Override
    public void saveRentalItem(String rentalId, String bookId, int qty, double price) throws SQLException {
        String sql = "INSERT INTO rental_item (rentalId, bookId, quantity, rentalCost) VALUES (?, ?, ?, ?)";
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, rentalId);
        pst.setString(2, bookId);
        pst.setInt(3, qty);
        pst.setDouble(4, price);

        pst.executeUpdate();
    }
}
