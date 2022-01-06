package com.example.logosproject.service;


import com.example.logosproject.details.CustomUserDetails;
import com.example.logosproject.models.User;
import com.example.logosproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRep.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(user);
    }
}
