package edu.icet.model;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    private int employeeId;
    private String employeeName;
    private String employeRole;
    private String employeeEmailAddress;
    private String employeePassword;


}
