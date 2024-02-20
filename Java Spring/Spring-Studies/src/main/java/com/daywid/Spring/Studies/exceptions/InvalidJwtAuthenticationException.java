package com.daywid.Spring.Studies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
 * Custom exception for invalid JWT authentication
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException{

    private static final long serialVersionUID = 1l;
    /*
     * Constructor for InvalidJwtAuthenticationException
     * @param ex The exception message
     */
    public InvalidJwtAuthenticationException(String ex){
        super(ex);
    }
}
