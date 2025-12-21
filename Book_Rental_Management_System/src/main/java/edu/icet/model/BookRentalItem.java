package edu.icet.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRentalItem {
    private String bookId;

    private String book_title;

    private int quantity;

    private double rentalCost;


}
