package edu.icet.service.impl;

import edu.icet.repository.RentalItemRepository;
import edu.icet.repository.impl.RentalItemRepositoryImpl;
import edu.icet.service.RentalItemService;

import java.sql.SQLException;

public class RentalItemServiceImpl implements RentalItemService {

    RentalItemRepository rentalItemRepository = new RentalItemRepositoryImpl();

    @Override
    public void saveRentalItem(String rentalId, String bookId, int qty, double price) {
        try {
            rentalItemRepository.saveRentalItem(rentalId,bookId,qty,price);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
