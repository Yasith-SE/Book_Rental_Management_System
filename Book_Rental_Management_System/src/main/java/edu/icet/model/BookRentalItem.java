package edu.icet.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRentalItem {

    private String rentalId;

    private String bookId;

    private String bookTitle;

    private int quantity;

    private double rentalCost;


}
