package com.Zalabat.Mart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Admin(String name, String email, String password) {
        super(name, email, password,"Admin");
    }

}
