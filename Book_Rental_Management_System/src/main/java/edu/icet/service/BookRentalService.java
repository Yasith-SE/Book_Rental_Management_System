package edu.icet.service;

import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.model.RentalTableModel;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public interface BookRentalService {


        boolean placeRental(String rentalId, String nic, String name, LocalDate issueDate, LocalDate dueDate, List<BookRentalItem> items);

        ObservableList<RentalTableModel> getAllRentals();


}
