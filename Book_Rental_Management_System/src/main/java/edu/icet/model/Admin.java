package edu.icet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Admin {
    private String adminId;
    private String adminName;

    private String adminEmail;
    private String adminPassword;

}
