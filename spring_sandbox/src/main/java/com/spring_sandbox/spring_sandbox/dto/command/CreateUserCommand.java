package com.spring_sandbox.spring_sandbox.dto.command;

import javax.validation.constraints.NotBlank;

import com.spring_sandbox.spring_sandbox.util.validation.CommandValidator;

import lombok.Getter;

@Getter
public class CreateUserCommand implements CreateCommand{
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;

    public void validate() {
		CommandValidator<CreateUserCommand> commandValidator =
				new CommandValidator<>();
		commandValidator.validate(this);//This valida uma instancia dessa mesma classe
	}
}