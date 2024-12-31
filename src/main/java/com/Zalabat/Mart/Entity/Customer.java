package com.Zalabat.Mart.Entity;

import jakarta.persistence.*;

@Table(name = "Customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    public Customer(){};
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {return id;}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
