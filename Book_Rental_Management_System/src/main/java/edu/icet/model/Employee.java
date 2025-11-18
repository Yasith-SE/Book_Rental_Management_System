package edu.icet.model;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    private String employeeId;
    private String employeeName;

    private String emailAddress;
    private String password;


}
