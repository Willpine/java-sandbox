package com.spring_sandbox.spring_sandbox.util.exception;

public class NotFoundException extends RuntimeException{
        
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
		super("NOT FOUND !!!!!!!!!!!");
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
