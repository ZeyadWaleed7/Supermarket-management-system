package com.Zalabat.Mart.DTOs;

public class UserDTO {
    private String email;
    private String password;
    private String name;

    public UserDTO(){};

    public UserDTO(String name,String email, String password) {
        this.name=name;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
}
