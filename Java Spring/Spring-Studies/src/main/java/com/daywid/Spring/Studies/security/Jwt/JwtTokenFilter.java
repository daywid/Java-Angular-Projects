package com.daywid.Spring.Studies.security.Jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/*
 * This class represents a filter for processing JWT tokens.
 */
public class JwtTokenFilter extends GenericFilterBean
{
	@Autowired
	private JwtTokenProvider tokenProvider;	
	/*
	 * Constructs a new JwtTokenFilter with the specified token provider.
	 * 
	 * @param tokenProvider the token provider
	 */
	public JwtTokenFilter(JwtTokenProvider tokenProvider) 
	{
		this.tokenProvider = tokenProvider;
	}
	/*
	 * Filters the request and response to process the JWT token.
	 * 
	 * @param request the servlet request
	 * @param response the servlet response
	 * @param chain the filter chain
	 * @throws IOException if an I/O error occurs
	 * @throws ServletException if the filter encounters an exception
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException 
	{
		String token = tokenProvider.resolveToken((HttpServletRequest) request);
		if (token != null && tokenProvider.validateToken(token)) 
		{
			Authentication auth = tokenProvider.getAuthentication(token);
			if (auth != null) 
			{
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);		
	}
}