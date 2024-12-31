package com.Zalabat.Mart.Services;

import com.Zalabat.Mart.Repository.EmployeeRepo;
import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private UserRepo userRepo;

    public boolean addEmployee(String name, String email, String password, int transactionsCount, String joinDate) {

        if(!userRepo.findAllByEmail(email).isEmpty()) {
            System.out.println("Error: An employee with this email already exists.");
            return false;
        }

        employeeRepo.save(new Employee(name, email, password,joinDate));
        System.out.println("Employee added successfully: " + name);
        return true;
    }

    public void displayEmployees() {
        if (employeeRepo.findAll().isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("Employees in the system:");
        for (Employee emp : employeeRepo.findAll()) {
            System.out.println("Name: " + emp.getName() + ", Email: " + emp.getEmail() + ", Join Date: " + emp.getJoinDate());
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

}
