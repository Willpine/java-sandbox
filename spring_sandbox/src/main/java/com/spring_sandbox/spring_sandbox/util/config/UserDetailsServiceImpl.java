package com.spring_sandbox.spring_sandbox.util.config;

import com.spring_sandbox.spring_sandbox.domain.User;
import com.spring_sandbox.spring_sandbox.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return user;
    }
    
}
