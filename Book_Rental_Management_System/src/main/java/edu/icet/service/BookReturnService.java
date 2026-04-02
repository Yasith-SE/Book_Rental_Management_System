package edu.icet.service;

import edu.icet.model.BookReturn;

public interface BookReturnService {

    BookReturn getRentalDetails(String rentalId);

    boolean returnBook(BookReturn bookReturn);

    long calculateOverdueDays(java.time.LocalDate dueDate, java.time.LocalDate returnDate);

    double calculateFine(long overdueDays, double finePerDay);
}