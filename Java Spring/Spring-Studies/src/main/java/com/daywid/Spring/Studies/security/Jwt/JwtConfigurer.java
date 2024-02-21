// package com.daywid.Spring.Studies.security.Jwt;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.DefaultSecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// /*
//  * Configures JWT security for the application.
//  */
// public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>
// {    
//     @Autowired
//     private JwtTokenProvider tokenProvider;
//     /*
//      * Constructs a JwtConfigurer with the specified token provider.
//      * 
//      * @param tokenProvider the token provider
//      */
//     public JwtConfigurer(JwtTokenProvider tokenProvider) 
//     {
//         this.tokenProvider = tokenProvider;
//     }
//     /*
//      * Configures the JWT token filter for the HTTP security.
//      * 
//      * @param http the HTTP security configuration
//      * @throws Exception if an error occurs during configuration
//      */
//     @Override
//     public void configure(HttpSecurity http) throws Exception 
//     {
//         JwtTokenFilter customFilter = new JwtTokenFilter(tokenProvider);
//         http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//     }
// }
