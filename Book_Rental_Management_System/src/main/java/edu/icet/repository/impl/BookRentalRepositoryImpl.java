package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.model.BookStore;
import edu.icet.repository.BookRentalRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookRentalRepositoryImpl implements BookRentalRepository {


    @Override
    public void saveRental(Connection con, String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate) throws SQLException {

        String sql = "INSERT INTO rental (rentalId, NIC, customerName, issue_date, due_date) VALUES (?,?,?,?,?)";

        try(PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, rentalId);
            pst.setString(2, nic);
            pst.setString(3, name);
            pst.setDate(4, java.sql.Date.valueOf(issueDate));
            pst.setDate(5, java.sql.Date.valueOf(dueDate));

            pst.executeUpdate();
        }
    }

    @Override
    public void saveRentalItem(Connection con, String rentalId, BookRentalItem item) throws SQLException {

        String sql = "INSERT INTO rental_item (rentalId, bookId, bookTitle, quantity, rentalCost) VALUES (?,?,?,?,?)";

        try(PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, rentalId);
            pst.setString(2, item.getBookId());
            pst.setString(3, item.getBookTitle());
            pst.setInt(4, item.getQuantity());
            pst.setDouble(5, item.getRentalCost());

            pst.executeUpdate();
        }
    }

    @Override
    public void updateBookQty(Connection con, String bookId, int qty) throws SQLException {
        String sql = "UPDATE book_registration SET quantity = quantity - ? WHERE bookId = ?";

        try(PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, qty);
            pst.setString(2, bookId);

            pst.executeUpdate();
        }
    }
}
