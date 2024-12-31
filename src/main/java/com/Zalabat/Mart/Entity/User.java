package com.Zalabat.Mart.Entity;

import jakarta.persistence.*;

@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "User_name")
    protected String name;

    @Column(unique = true)
    protected String email;

    protected String password;
    protected String type;

    //public User(){}
//    public User(String email,String Password){
//        this.email=email;
//        this.password=Password;
//    }
    public User(String name, String email, String password,String type) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.type=type;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

}
