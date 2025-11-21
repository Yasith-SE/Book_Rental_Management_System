package edu.icet.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRental {

    private String rentalId;

    private String bookId;
    private String bookTitle;

    private String NIC;
    private String customerName;

    private LocalDate issueDate;
    private LocalDate dueDate;

    private int BookQuantity;
    private double bookRentalCost;

}
