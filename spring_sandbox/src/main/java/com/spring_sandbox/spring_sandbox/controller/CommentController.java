package com.spring_sandbox.spring_sandbox.controller;

import com.spring_sandbox.spring_sandbox.dto.command.CreateCommentCommand;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {
    @PostMapping
    public ResponseEntity<Object> addComment(CreateCommentCommand command){

        return ResponseEntity.ok().build();
    }
}
