package com.Zalabat.Mart.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Table(name="employees")
@Entity
public class Employee extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String joinDate;
    protected int transactionsCount;

    public Employee(){
        super(null,null,null,"Employee");
    };

    public Employee(String name, String email, String password) {
        super(name, email, password,"Employee");
        this.transactionsCount = 0;
    }

    public Employee(String name, String email, String password, String joinDate) {
        super(name, email, password,"Employee");
        this.transactionsCount = 0;
        this.joinDate = joinDate;
    }

    public String getJoinDate() {
        return joinDate;
    }
}
