package com.Zalabat.Mart.Classes;

import com.Zalabat.Mart.Entity.Admin;
import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Entity.User;

public class UserFactory {
    public User createUser(String name,String email, String password,String type) {
        if (type.equals("Admin")) {
            return new Admin(name,email,password);
        } else if (type.equals("Employee")) {
            return new Employee(name,email, password);
        } else {
            return null;
        }
    }
}
