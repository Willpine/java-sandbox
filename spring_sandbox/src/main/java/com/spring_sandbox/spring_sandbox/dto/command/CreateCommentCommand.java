package com.spring_sandbox.spring_sandbox.dto.command;

import com.spring_sandbox.spring_sandbox.util.validation.CommandValidator;

import lombok.Getter;

@Getter
public class CreateCommentCommand implements CreateCommand{
    private String userName;
    private String text;
    @Override
    public void validate() {
        CommandValidator<CreateCommentCommand> commandValidator =
				new CommandValidator<>();
		commandValidator.validate(this);//This valida uma instancia dessa mesma classe
        
    }
}
