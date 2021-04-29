package com.spring_sandbox.spring_sandbox.repository;

import com.spring_sandbox.spring_sandbox.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
    
}
