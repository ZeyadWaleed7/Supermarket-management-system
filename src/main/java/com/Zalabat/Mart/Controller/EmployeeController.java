package com.Zalabat.Mart.Controller;

import com.Zalabat.Mart.DTOs.EmployeeDTO;
import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Repository.EmployeeRepo;
import com.Zalabat.Mart.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Employee")
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String displayPage(Model model){
        model.addAttribute("EmployeeDTO", new EmployeeDTO(null,null,null,null));
        return "AddEmployee";
    }

    @PostMapping("/Add")
    public String addEmployee(@ModelAttribute("EmployeeDTO") EmployeeDTO employee,Model model){
        if(!employeeService.addEmployee(employee.getName(),employee.getEmail(),employee.getPassword(),0,employee.getJoinDate())){
            return "redirect:/Employee";
        }
        return "redirect:/Employee";
    }

}
