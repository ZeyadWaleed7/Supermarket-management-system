package com.Zalabat.Mart.DTOs;

public class EmployeeDTO {
    protected String name;
    protected String email;
    protected String password;
    protected Integer id;
    protected String joinDate;
    protected int transactionsCount;
    //public EmployeeDTO(){};
    public EmployeeDTO(String name, String email, String password,String joinDate) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.joinDate = joinDate;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getJoinDate() {
        return joinDate;
    }

}
