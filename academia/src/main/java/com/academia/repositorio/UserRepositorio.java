package com.academia.repositorio;

import com.academia.modelo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositorio {
    public User findUserByEmail(String email){
        User user = new User(email,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}