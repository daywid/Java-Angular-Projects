package com.daywid.Spring.Studies.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.daywid.Spring.Studies.exceptions.ExceptionResponse;
import com.daywid.Spring.Studies.exceptions.InvalidJwtAuthenticationException;
import com.daywid.Spring.Studies.exceptions.UnsupportedMathOperationException;

/*
 * This class handles custom exceptions and provides customized responses for each exception.
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    /*
     * Handles all types of exceptions and provides a customized response with INTERNAL_SERVER_ERROR status code.
     * 
     * @param ex The exception that occurred.
     * @param request The web request.
     * @return ResponseEntity containing the customized exception response.
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(), 
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    /*
     * Handles UnsupportedMathOperationException and provides a customized response with BAD_REQUEST status code.
     * 
     * @param ex The exception that ocurred
     * @param request The web request
     * @return ResponseEntity containing the customized exception response
     */
    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
        
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(), 
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        
    }
    /*
     * Handles InvalidJwtAuthenticationException and provides a customized response with FORBIDDEN status code.
     * 
     * @param ex The exception that ocurred
     * @param request The web request
     * @return ResponseEntity containing the customized exception response
     */
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidAuthenticationExceptions(Exception ex, WebRequest request){
        
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(), 
            request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);        
    }
}
