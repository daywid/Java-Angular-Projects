package com.daywid.Spring.Studies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Custom exception for resource not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    /*
     * Constructor for ResourceNotFoundException
     * @param ex the exception message
     */
    public ResourceNotFoundException(String ex){
        super(ex);
    }
}