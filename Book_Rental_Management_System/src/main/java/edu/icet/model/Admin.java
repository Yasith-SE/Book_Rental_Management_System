package edu.icet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Admin {
    private int adminId;
    private String adminName;
    private String role;
    private String adminEmail;
    private String adminPassword;

}
