package com.Zalabat.Mart.Services;

import com.Zalabat.Mart.Entity.User;
import com.Zalabat.Mart.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

}
