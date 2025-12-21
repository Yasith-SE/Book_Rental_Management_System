package edu.icet.service.impl;

import edu.icet.DBConnector.DBConnection;
import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.repository.BookRentalRepository;
import edu.icet.repository.impl.BookRentalRepositoryImpl;
import edu.icet.service.BookRentalService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookRentalServiceImpl implements BookRentalService {

    private final BookRentalRepository bookRentalRepository = new BookRentalRepositoryImpl();


    @Override
    public boolean placeRental(BookRental rental, List<BookRentalItem> items) {
        Connection con = null;

        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false); // START TRANSACTION

            bookRentalRepository.saveRental(rental);

            for (BookRentalItem item : items) {
                bookRentalRepository.saveRentalItem(rental.getRentalId(), item);
                bookRentalRepository.updateBookQty(item.getBookId(), item.getQuantity());
            }

            con.commit(); // SUCCESS
            return true;

        } catch (Exception e) {
            try {
                if (con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
