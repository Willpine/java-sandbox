package com.spring_sandbox.spring_sandbox.repository;

import com.spring_sandbox.spring_sandbox.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
   
}
