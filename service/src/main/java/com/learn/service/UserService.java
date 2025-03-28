package com.learn.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.domain.User;
import com.learn.repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public Optional<User> findUserByUsername(String name){
        return userRepo.findByUsername(name);
    }
}
