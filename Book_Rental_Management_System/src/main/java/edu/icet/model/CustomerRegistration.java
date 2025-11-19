package edu.icet.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class CustomerRegistration {

    private String NIC;
    private String fullName;
    private LocalDate Dob;
    private int age;
    private String phoneNo;
    private String emailAddress;
    private String homeAddress;
    private String adultStudent;

}
