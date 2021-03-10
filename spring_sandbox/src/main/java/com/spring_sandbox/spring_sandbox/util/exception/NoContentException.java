package com.spring_sandbox.spring_sandbox.util.exception;

public class NoContentException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public NoContentException() {
		super();
	}

	public NoContentException(String message) {
		super(message);
	}
}
