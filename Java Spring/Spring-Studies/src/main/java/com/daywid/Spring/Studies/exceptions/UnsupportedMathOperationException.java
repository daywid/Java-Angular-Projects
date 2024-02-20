package com.daywid.Spring.Studies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
 * This class represents an exception for unsupported math operations.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{
    
    private static final long seriaVersionUID = 1L;

    public UnsupportedMathOperationException(String ex){
        super(ex);
    }
    /*
     * Get the serialVersionUID
     * @return the serialVersionUID
     */
    public static long getSeriaversionuid() {
        return seriaVersionUID;
    }    
}
