package com.Zalabat.Mart.Repository;

import com.Zalabat.Mart.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer> {
    ArrayList<Customer> findAll();
    ArrayList<Customer> findAllByEmail(String email);
}
