package edu.icet.service.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.repository.BookRentalRepository;
import edu.icet.repository.impl.BookRentalRepositoryImpl;
import edu.icet.service.BookRentalService;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookRentalServiceImpl implements BookRentalService {

    private final BookRentalRepository bookRentalRepository = new BookRentalRepositoryImpl();


    @Override
    public boolean placeRental(String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate, List<BookRentalItem> items) {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false); // 1. Start Transaction

            // 2. Save the main Rental info first
            bookRentalRepository.saveRental(con, rentalId, nic, name, issueDate, dueDate);

            // 3. Save each Book in the Bucket
            for (BookRentalItem item : items) {
                bookRentalRepository.saveRentalItem(con,rentalId, item);
                bookRentalRepository.updateBookQty(con, item.getBookId(), item.getQuantity());
            }

            con.commit(); // 4. Save Changes to Database
            return true;

        } catch (Exception e) {
            try {
                if (con != null) con.rollback(); // Undo if error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
