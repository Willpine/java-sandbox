package com.spring_sandbox.spring_sandbox.util.exception;

public class MessageErrorDetail {
    private String field;
	private String errorMessage;
	
	public String getField() {
		return field;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public MessageErrorDetail(String field, String errorMessage) {
		this.field = field;
		this.errorMessage = errorMessage;
	}
	
	public MessageErrorDetail(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
