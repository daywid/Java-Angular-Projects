package com.daywid.Spring.Studies;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

/*
 * This is the main class that starts the Spring application
 */
@SpringBootApplication
@ComponentScan("com.daywid.Spring.Studies.config")
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
        
        // Create a map to store password encoders.
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        
        // Create a PBKDF2 password encoder.
        Pbkdf2PasswordEncoder pbkdf2Encoder =
        		new Pbkdf2PasswordEncoder(
    				"", 8, 185000,
    				SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        // Add the PBKDF2 password encoder to the map.
        encoders.put("pbkdf2", pbkdf2Encoder);

        // Create a delegating password encoder.
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        
        // Set the default password encoder for matches.
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        
        // Encode passwords and print the results.
        String result1 = passwordEncoder.encode("admin123");
        String result2 = passwordEncoder.encode("admin234");
        System.out.println("My hash result1 " + result1);
        System.out.println("My hash result2 " + result2);
    }
}