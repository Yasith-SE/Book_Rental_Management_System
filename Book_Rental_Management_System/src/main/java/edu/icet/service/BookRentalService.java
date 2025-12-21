package edu.icet.service;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;

import java.util.List;

public interface BookRentalService {


        boolean placeRental(BookRental rental, List<BookRentalItem> items);



}
