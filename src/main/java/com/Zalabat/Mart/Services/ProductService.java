package com.Zalabat.Mart.Services;

import com.Zalabat.Mart.Entity.Product;
import com.Zalabat.Mart.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void addProduct(String name, double price, int stock, String barCode, String expDate) {
        if(!productRepo.findAllByBarCode(barCode).isEmpty()) {
            System.out.println("Error: A product with this barcode already exists.");
            return;
        }
        productRepo.save(new Product(name, price, stock,barCode, expDate));
    }

    public void deleteProduct(String barCode){
        productRepo.deleteByBarCode(barCode);
    }
}
