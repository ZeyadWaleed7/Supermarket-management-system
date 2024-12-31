package com.Zalabat.Mart.Entity;

import com.Zalabat.Mart.Classes.Expirable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(name="products")
@Entity
public class Product extends Expirable {
    @Id
    protected String barCode;
    protected String itemName;
    protected int stock;
    protected double price;

    public Product(){};
    public Product(String itemName, double price, int stock, String barCode, String expDate) {
        super(expDate);
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.barCode = barCode;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty");
        }
        this.itemName = itemName;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
