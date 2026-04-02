package edu.icet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalTableModel {
    private String rentalId;
    private String nic;
    private String bookId;
    private LocalDate rentalDate;
    private LocalDate overdueDate;
    private Double finalAmount;
}