package edu.icet.model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookReturn {

    private String rentalId;

    private String bookId;
    private String bookTitle;

    private String NIC;
    private String customerName;

    private LocalDate isseuDate;
    private LocalDate dueDate;

    private LocalDate returnDate;

    private String bookReturned;
    private String bookNotReturned;

    private LocalDate overDueDate;
    private LocalDate finePerDay;

    private double totalFine;


}
