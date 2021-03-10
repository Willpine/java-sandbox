package com.spring_sandbox.spring_sandbox.repository;

import com.spring_sandbox.spring_sandbox.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
