package edu.icet.service;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;

import java.time.LocalDate;
import java.util.List;

public interface BookRentalService {


        boolean placeRental(String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate, List<BookRentalItem> items);



}
