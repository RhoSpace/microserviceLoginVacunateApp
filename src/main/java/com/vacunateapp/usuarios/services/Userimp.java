package com.vacunateapp.usuarios.services;

import com.vacunateapp.usuarios.model.User;
import com.vacunateapp.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Userimp implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.findByRut(username);
        

        List<GrantedAuthority> roles = new ArrayList<>();
        if(user.isRole()) {
        	roles.add(new SimpleGrantedAuthority("admin"));
        }else if(!user.isRole()) {
        	roles.add(new SimpleGrantedAuthority("personal"));
        }
        

        UserDetails details = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);
        return details;
    }

}
