package com.Zalabat.Mart.Classes;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public abstract class Expirable {
    protected Date expDate;


    public Expirable(){};
    public Expirable(String expDate) {
        this.expDate = expDate;
    }

    protected boolean isExpired(){
        return new Date().after(expDate);
    }
    protected void setExpDate(Date expDate){
        this.expDate = expDate;
    }
}