package com.Zalabat.Mart.Controller;

import com.Zalabat.Mart.Classes.UserFactory;
import com.Zalabat.Mart.DTOs.UserDTO;
import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Entity.User;
import com.Zalabat.Mart.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userServices;

    @GetMapping
    public String displayPage(Model model){
        return "HomePage";
    }

    @PostMapping
    private String displayHere(@ModelAttribute("UserDTO") UserDTO userDto,Model model){
        User user = userServices.getUserByEmail(userDto.getEmail());
        if(user == null){
            model.addAttribute("error","User Not Found");
            return "redirect:/";
        }

        if(!user.checkPassword(userDto.getPassword())){
            model.addAttribute("error","User Not Found");
            return "redirect:/";
        }
        User send=(new UserFactory()).createUser(user.getName(),user.getEmail(),user.getPassword(),user.getType());
        model.addAttribute("user",send);
        return "HomePage";
    }

}
