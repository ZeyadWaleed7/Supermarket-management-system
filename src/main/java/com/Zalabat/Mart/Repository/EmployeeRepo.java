package com.Zalabat.Mart.Repository;

import com.Zalabat.Mart.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    ArrayList<Employee> findAll();
}
