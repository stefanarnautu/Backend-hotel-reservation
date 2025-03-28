package com.learn.web.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService{
    private final UserService userService;

    public CustomUserDetailService(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findUserByUsername(username)
              .map(user -> User.withUsername(user.getUsername())
                                .password(user.getPassword()) 
                                .roles(user.getRole().toString())
                                .build())
    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
