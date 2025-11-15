package edu.icet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class BookStore {

    private String bookId;

    private String bookTitle;

    private String author;

    private String category;

    private int quantity;

    private double price;

}
