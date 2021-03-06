package com.spring_sandbox.spring_sandbox.service;

import javax.transaction.Transactional;

import com.spring_sandbox.spring_sandbox.domain.User;
import com.spring_sandbox.spring_sandbox.dto.command.CreateUserCommand;
import com.spring_sandbox.spring_sandbox.repository.RoleRepository;
import com.spring_sandbox.spring_sandbox.repository.UserRepository;
import com.spring_sandbox.spring_sandbox.util.exception.BadRequestException;
import com.spring_sandbox.spring_sandbox.util.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service @Transactional
public class SandboxUserService implements SandboxService, UserDetailsService{
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public User add (CreateUserCommand command){
        if(userRepository.existsById(command.getName()))
            throw new BadRequestException("Username already taken.");
        User user = User.addUser(command);
        addUserRolesTo(user);
        userRepository.save(user);
        return userRepository.save(user);
    }

    public User retrieve (String username){
        return userRepository.findById(username).orElseThrow(() -> new NotFoundException("Usuário "+username+" não encontrado"));
    }

    public Page<User> retrievePage (Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new org.springframework.security.core.userdetails
            .User(user.getName(), user.getPassword(),true,true,true,true, user.getAuthorities());
    }

    private void addUserRolesTo(User user) {
        user.getRoles().add(roleRepository.findById("ROLE_USER")
        .orElseThrow(() -> new NotFoundException("Role not found")));
    }
}
