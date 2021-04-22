package com.spring_sandbox.spring_sandbox.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.spring_sandbox.spring_sandbox.domain.User;
import com.spring_sandbox.spring_sandbox.dto.command.CreateUserCommand;
import com.spring_sandbox.spring_sandbox.repository.UserRepository;
import com.spring_sandbox.spring_sandbox.util.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SandboxUserService implements SandboxService{
    
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public User add (CreateUserCommand command){
        User user = User.addUser(command);
        return userRepository.save(user);
    }

    public User persistenceAdd (CreateUserCommand command){
        User user = User.addUser(command);
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    public User retrieve (Long id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário "+id+" não encontrado"));
    }

    public Page<User> retrievePage (Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
