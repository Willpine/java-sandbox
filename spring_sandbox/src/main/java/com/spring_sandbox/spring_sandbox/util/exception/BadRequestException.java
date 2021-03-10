package com.spring_sandbox.spring_sandbox.util.exception;

import java.util.List;

public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private MessageErrorResponse errorResponse;
	
	public MessageErrorResponse getErrorResponse() {
		return this.errorResponse;
	}
	
	public BadRequestException() {
		super("BAD REQUEST!!!!");
	}
	
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(List<MessageErrorDetail> errors) {
		this.errorResponse = 
				new MessageErrorResponse("Errors while trying to save", errors);
	}
}
