package com.Zalabat.Mart.Entity;

import jakarta.persistence.*;

@Table(name="Catalog")
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;

    public Catalog(){};
    public Catalog(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {return id;}

    public int getQuantity() {
        return quantity;
    }
}
