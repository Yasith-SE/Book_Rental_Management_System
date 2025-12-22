package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.repository.BookRentalRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookRentalRepositoryImpl implements BookRentalRepository {


    @Override
    public void saveRental(String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate) throws SQLException {
        String sql = "INSERT INTO rental VALUES (?,?,?,?,?)";
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, rentalId);
        pst.setString(2, nic);
        pst.setString(3,name);
        pst.setDate(4, java.sql.Date.valueOf(issueDate));
        pst.setDate(5, java.sql.Date.valueOf(dueDate));

        pst.executeUpdate();
    }

    @Override
    public void saveRentalItem(String rentalId, BookRentalItem item) throws SQLException {
        String sql = "INSERT INTO rental_item (rentalId, bookId, quantity, rentalCost) VALUES (?,?,?,?)";
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, rentalId);
        pst.setString(2, item.getBookId());
        pst.setInt(3, item.getQuantity());
        pst.setDouble(4, item.getRentalCost());

        pst.executeUpdate();
    }

    @Override
    public void updateBookQty(String bookId, int qty) throws SQLException {
        String sql = "UPDATE book_registration SET quantity = quantity - ? WHERE bookId = ?";
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, qty);
        pst.setString(2, bookId);

        pst.executeUpdate();
    }
}
