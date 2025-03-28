package com.learn.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
