package edu.icet.service.impl;

import edu.icet.model.BookReturn;
import edu.icet.repository.BookReturnRepository;
import edu.icet.repository.impl.BookReturnRepositoryImpl;
import edu.icet.service.BookReturnService;
import java.time.temporal.ChronoUnit;
import java.sql.SQLException;

public class BookReturnServiceImpl implements BookReturnService {

    BookReturnRepository repository = new BookReturnRepositoryImpl();

    @Override
    public BookReturn getRentalDetails(String rentalId) {
        try {
            return repository.findRentalById(rentalId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean returnBook(BookReturn bookReturn) {
        try {
            return repository.saveReturn(bookReturn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long calculateOverdueDays(java.time.LocalDate dueDate, java.time.LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            return ChronoUnit.DAYS.between(dueDate, returnDate);
        }
        return 0;
    }

    @Override
    public double calculateFine(long overdueDays, double finePerDay) {
        return overdueDays * finePerDay;
    }
}