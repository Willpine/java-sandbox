package com.spring_sandbox.spring_sandbox.dto.command;

import lombok.Getter;

@Getter
public class CreateCommentCommand {
    private String userName;
    private String text;
}
