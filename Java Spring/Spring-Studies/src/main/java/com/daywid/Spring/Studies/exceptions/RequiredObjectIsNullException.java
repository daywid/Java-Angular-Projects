package com.daywid.Spring.Studies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Custom exception for required object is null
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * Default constructor with a predefined message
	 */
	public RequiredObjectIsNullException() {
		super("It is not allowed to persist a null object!");
	}	
	
	/*
	 * Constructor with a custom exception message
	 * @param ex the custom exception message
	 */
	public RequiredObjectIsNullException(String ex) {
		super(ex);
	}

}