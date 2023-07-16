package com.bookhub.bookhubapi.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstname;
    private String lastname;
    private String password;
    private String mail;
    private int phone;
    private String address;
    private int age;
    @ManyToOne
    private Role role;

}
