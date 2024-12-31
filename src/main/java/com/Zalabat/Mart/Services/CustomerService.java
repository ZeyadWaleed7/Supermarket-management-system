package com.Zalabat.Mart.Services;

import com.Zalabat.Mart.Entity.Customer;
import com.Zalabat.Mart.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public void addCustomer(String name, String email) {
        if(!customerRepo.findAllByEmail(email).isEmpty()) {
            System.out.println("Error: A Customer with this email already exists.");
            return;
        }
        customerRepo.save(new Customer(name, email));
    }

    public void addMembership(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        boolean found = false;
        for (Customer customer : customerRepo.findAll()) {
            if (customer.getId().equals(customerId)) {
                found = true;
                System.out.println("Membership successfully set for customer: " + customer.getName());
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid customer identifier.");
        }
    }


}


