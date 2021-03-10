package com.spring_sandbox.spring_sandbox.util.exception;

import java.time.LocalDateTime;
import java.util.List;

public class MessageErrorResponse {
    private String message;
	private LocalDateTime datetime;//Hora em que ocorreu o erro
	private List<MessageErrorDetail> errors;
	
	public String getMessage() {
		return message;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public List<MessageErrorDetail> getErrors() {
		return errors;
	}
	
	MessageErrorResponse(String message, List<MessageErrorDetail> errors){
		this.message = message;
		this.datetime = LocalDateTime.now();
		this.errors = errors;
	}
}
