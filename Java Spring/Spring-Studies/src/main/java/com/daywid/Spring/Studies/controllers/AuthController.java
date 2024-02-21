package com.daywid.Spring.Studies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daywid.Spring.Studies.data.vo.v1.security.AccountCredentialsVO;
import com.daywid.Spring.Studies.services.AuthServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/*
 * Controller for authentication endpoints.
 */

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController 
{    
    @Autowired
    AuthServices authServices;
    /*
     * Authenticas a user and returns a token.
     * 
     * @param data The user's account credentials.
     * @return ResponseEntity containing the token or an error message.
     */
    @SuppressWarnings("rawtypes")
    @Operation(summary = "Authenticates a user and returns a token")
    @PostMapping(value = "/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data)
    {    
        if(checkIfParamIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body("Invalid client request!");
        
        var token =  authServices.signIn(data);

        if(token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");      
        {
            return token;
        }
    }
    /*
     * Checks if the data parameter is null or empty.
     * 
     * @param data The user's account credentials.
     * @return true if the data parameter is null or empty, false otherwise.
     */
    private boolean checkIfParamIsNotNull(AccountCredentialsVO data)
    {
        return data == null || data.getUsername() == null || data.getUsername().isBlank() ||
        data.getPassword().isBlank();
    }
}
