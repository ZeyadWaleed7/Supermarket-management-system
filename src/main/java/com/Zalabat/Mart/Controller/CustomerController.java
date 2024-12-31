package com.Zalabat.Mart.Controller;

import com.Zalabat.Mart.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Customer")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService employeeService;

    @GetMapping("/AddCust")
    public void addCustomer(){
        employeeService.addCustomer("ahmedhanafy@gmail.com","123456");
    }

}
