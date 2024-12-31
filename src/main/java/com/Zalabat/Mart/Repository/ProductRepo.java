package com.Zalabat.Mart.Repository;

import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface ProductRepo extends CrudRepository<Product,String> {
    ArrayList<Product> findAll();

    void deleteByBarCode(String barCode);

    ArrayList<Product> findAllByBarCode(String barCode);
}
