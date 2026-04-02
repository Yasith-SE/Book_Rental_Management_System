package edu.icet.model;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookReturn{

    private String rentalId;

    private String bookId;

    private String bookTitle;

    private String customerId;

    private String customerName;

    private LocalDate issueDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private String status;

    private int overDueDays;

    private Double finePerDay;

    private Double totalFine;
}