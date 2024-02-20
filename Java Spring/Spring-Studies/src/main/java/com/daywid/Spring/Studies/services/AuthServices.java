package com.daywid.Spring.Studies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daywid.Spring.Studies.data.vo.v1.security.AccountCredentialsVO;
import com.daywid.Spring.Studies.data.vo.v1.security.TokenVO;
import com.daywid.Spring.Studies.repositories.UserRepository;
import com.daywid.Spring.Studies.security.Jwt.JwtTokenProvider;

/*
 * This class provides authentication services for the application.
 */
@Service
public class AuthServices 
{
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    /*
     * Handles user sign in.
     * @param data The account credentials.
     * @return ResponseEntity containing the token response.
     */
    @SuppressWarnings("rawtypes")
    public ResponseEntity signIn(AccountCredentialsVO data)
    {
        try 
        {
            var username =  data.getUsername();
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
        var user = repository.findByUsername(username);

        var tokenResponse = new TokenVO();

        if (user != null) {
            tokenResponse = tokenProvider.createAccessToken(username, user.getRoles());
        }
        else
        {
            throw new UsernameNotFoundException("Username: " + username + "not found");
        }
        return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
