package com.Zalabat.Mart.Repository;

import com.Zalabat.Mart.Entity.Employee;
import com.Zalabat.Mart.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    ArrayList<User> findAllByEmail(String email);
    User findByEmail(String email);
}
