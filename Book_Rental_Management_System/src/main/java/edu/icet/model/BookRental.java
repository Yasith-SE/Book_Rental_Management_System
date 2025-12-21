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

    private String nic;

    private LocalDate issueDate;

    private LocalDate dueDate;


}
