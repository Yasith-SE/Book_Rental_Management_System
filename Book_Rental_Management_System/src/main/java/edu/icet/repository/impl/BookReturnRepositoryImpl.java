package edu.icet.repository.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookReturn;
import edu.icet.repository.BookReturnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookReturnRepositoryImpl implements BookReturnRepository {

    @Override
    public BookReturn findRentalById(String rentalId) throws SQLException {

        String sql = "SELECT r.rentalId, ri.bookId, ri.bookTitle, r.NIC, r.customerName, r.issue_date, r.due_date " +
                "FROM rental r " +
                "JOIN rental_item ri ON r.rentalId = ri.rentalId " +
                "WHERE r.rentalId = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, rentalId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return new BookReturn(
                    rs.getString("rentalId"),
                    rs.getString("bookId"),
                    rs.getString("bookTitle"),
                    rs.getString("NIC"),
                    rs.getString("customerName"),
                    rs.getDate("issue_date").toLocalDate(),
                    rs.getDate("due_date").toLocalDate(),
                    java.time.LocalDate.now(),
                    "Pending",
                    0,
                    0.0,
                    0.0
            );
        }
        return null;
    }
    @Override
    public boolean saveReturn(BookReturn bookReturn) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);


            String insertSql = "INSERT INTO book_returns (rentalId, bookId, nic, returnDate, overDueDays, fineAmount) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstInsert = connection.prepareStatement(insertSql);
            pstInsert.setString(1, bookReturn.getRentalId());
            pstInsert.setString(2, bookReturn.getBookId());
            pstInsert.setString(3, bookReturn.getCustomerId());
            pstInsert.setDate(4, java.sql.Date.valueOf(bookReturn.getReturnDate()));
            pstInsert.setInt(5, bookReturn.getOverDueDays());
            pstInsert.setDouble(6, bookReturn.getTotalFine());
            pstInsert.executeUpdate();


            String updateBookSql = "UPDATE book_registration SET quantity = quantity + 1 WHERE bookId = ?";
            PreparedStatement pstBook = connection.prepareStatement(updateBookSql);
            pstBook.setString(1, bookReturn.getBookId());
            pstBook.executeUpdate();



            connection.commit();
            return true;

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}