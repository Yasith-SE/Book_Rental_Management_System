package edu.icet.service;

public interface RentalItemService {

    void saveRentalItem(String rentalId, String bookId, int qty, double price);

}
