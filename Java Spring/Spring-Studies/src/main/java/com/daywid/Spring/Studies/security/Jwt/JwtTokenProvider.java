package com.daywid.Spring.Studies.security.Jwt;

// import java.util.Base64;
// import java.util.Date;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.JWTVerifier;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.interfaces.DecodedJWT;
// import com.daywid.Spring.Studies.data.vo.v1.security.TokenVO;
// import com.daywid.Spring.Studies.exceptions.InvalidJwtAuthenticationException;

// import jakarta.annotation.PostConstruct;
// import jakarta.servlet.http.HttpServletRequest;

// /*
//  * Provides JWT token generation and validation funcionality.
//  */
// @Service
// public class JwtTokenProvider 
// {
// 	@Value("${security.jwt.token.secret-key:secret}")
// 	private String secretKey = "secret";
	
// 	@Value("${security.jwt.token.expire-length:3600000}")
// 	private long validityInMilliseconds = 3600000; // 1h
	
// 	@Autowired
// 	private UserDetailsService userDetailsService;
	
// 	Algorithm algorithm = null;
	
// 	@PostConstruct
// 	protected void init() 
// 	{
// 		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
// 		algorithm = Algorithm.HMAC256(secretKey.getBytes());
// 	}
// 	/*
// 	 * Creates an access token and a refresh token for a given username and roles.
// 	 * 
// 	 * @param username the username
// 	 * @param roles the roles associated with the user
// 	 * @return a TokenVO object containing the access token and refresh token
// 	 */
// 	public TokenVO createAccessToken(String username, List<String> roles) 
// 	{
// 		Date now = new Date();
// 		Date validity = new Date(now.getTime() + validityInMilliseconds);
// 		var accessToken = getAccessToken(username, roles, now, validity);
// 		var refreshToken = getRefreshToken(username, roles, now);
		
// 		return new TokenVO(username, true, now, validity, accessToken, refreshToken);
// 	}
// 	/*
// 	 * Refreshes an access token using a refresh token.
// 	 * 
// 	 * @param refreshToken the refresh token
// 	 * @return a new TokenVO object containing the refreshed access token
// 	 */
// 	public TokenVO refreshToken(String refreshToken) 
// 	{
// 		if (refreshToken.contains("Bearer ")) refreshToken =
// 				refreshToken.substring("Bearer ".length());
		
// 		JWTVerifier verifier = JWT.require(algorithm).build();
// 		DecodedJWT decodedJWT = verifier.verify(refreshToken);
// 		String username = decodedJWT.getSubject();
// 		List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
// 		return createAccessToken(username, roles);
// 	}
// 	/*
// 	 * Returns the access token for a given username, roles and timestamps.
// 	 * 
// 	 * @param username The username.
// 	 * @param roles The roles associated with the user.
// 	 * @param now The current timestamp(Date).
// 	 * @param validity the expiration date of the token.
// 	 * @return The access token.
// 	 */
// 	private String getAccessToken(String username, List<String> roles, Date now, Date validity) 
// 	{
// 		String issuerUrl = ServletUriComponentsBuilder
// 				.fromCurrentContextPath().build().toUriString();
// 		return JWT.create()
// 				.withClaim("roles", roles)
// 				.withIssuedAt(now)
// 				.withExpiresAt(validity)
// 				.withSubject(username)
// 				.withIssuer(issuerUrl)
// 				.sign(algorithm)
// 				.strip();
// 	}
// 	/*
// 	 * Returns the refresh token for a given username and roles.
// 	 * 
// 	 * @param username The username.
// 	 * @param roles The roles associated with the user.
// 	 * @param now The current timestamp(Date).
// 	 * @return The refresh token.
// 	 */
// 	private String getRefreshToken(String username, List<String> roles, Date now) 
// 	{
// 		Date validityRefreshToken = new Date(now.getTime() + (validityInMilliseconds * 3));
// 		return JWT.create()
// 				.withClaim("roles", roles)
// 				.withIssuedAt(now)
// 				.withExpiresAt(validityRefreshToken)
// 				.withSubject(username)
// 				.sign(algorithm)
// 				.strip();
// 	}
// 	/*
// 	 * Returns the authentication object for a given token.
// 	 * 
// 	 * @param token The  JWT token.
// 	 * @return The authentication object.
// 	 */
// 	public Authentication getAuthentication(String token) 
// 	{
// 		DecodedJWT decodedJWT = decodedToken(token);
// 		UserDetails userDetails = this.userDetailsService
// 				.loadUserByUsername(decodedJWT.getSubject());
// 		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
// 	}
// 	/*
// 	 * Returns the decoded JWT token for a given token string.
// 	 * 
// 	 * @param token The token String.
// 	 * @return The decoded JWT object.
// 	 */
// 	private DecodedJWT decodedToken(String token) 
// 	{
// 		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
// 		JWTVerifier verifier = JWT.require(alg).build();
// 		DecodedJWT decodedJWT = verifier.verify(token);
// 		return decodedJWT;
// 	}
// 	/*
// 	 * Resolves the JWT token from the Authorization header of an HTTP request.
// 	 * @param req The HTTP request.
// 	 * @return The JWT token, or null if not found.
// 	 */
// 	public String resolveToken(HttpServletRequest req) 
// 	{
// 		String bearerToken = req.getHeader("Authorization");
		
// 		// Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFuZHJvIiwicm9sZXMiOlsiQURNSU4iLCJNQU5BR0VSIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImV4cCI6MTY1MjcxOTUzOCwiaWF0IjoxNjUyNzE1OTM4fQ.muu8eStsRobqLyrFYLHRiEvOSHAcss4ohSNtmwWTRcY
// 		if (bearerToken != null && bearerToken.startsWith("Bearer ")) 
// 		{
// 			return bearerToken.substring("Bearer ".length());
// 		}
// 		return null;
// 	}
// 	/**
// 	 * Validates the given token.
// 	 *
// 	 * @param  token  the token to be validated
// 	 * @return       true if the token is valid, false otherwise
// 	 */
// 	public boolean validateToken(String token) 
// 	{
// 		DecodedJWT decodedJWT = decodedToken(token);
// 		try 
// 		{
// 			if (decodedJWT.getExpiresAt().before(new Date())) 
// 			{
// 				return false;
// 			}
// 			return true;
// 		} 
// 		catch (Exception e) 
// 		{
// 			throw new InvalidJwtAuthenticationException("Expired or invalid JWT token!");
// 		}
// 	}
// }

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.daywid.Spring.Studies.data.vo.v1.security.TokenVO;
import com.daywid.Spring.Studies.exceptions.InvalidJwtAuthenticationException;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class JwtTokenProvider {

	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";
	
	@Value("${security.jwt.token.expire-length:3600000}")
	private long validityInMilliseconds = 3600000; // 1h
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	Algorithm algorithm = null;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}

	public TokenVO createAccessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		var accessToken = getAccessToken(username, roles, now, validity);
		var refreshToken = getRefreshToken(username, roles, now);
		
		return new TokenVO(username, true, now, validity, accessToken, refreshToken);
	}

	
	public TokenVO refreshToken(String refreshToken) {
		if (refreshToken.contains("Bearer ")) refreshToken =
				refreshToken.substring("Bearer ".length());
		
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJWT = verifier.verify(refreshToken);
		String username = decodedJWT.getSubject();
		List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
		return createAccessToken(username, roles);
	}
	
	private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
		String issuerUrl = ServletUriComponentsBuilder
				.fromCurrentContextPath().build().toUriString();
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(now)
				.withExpiresAt(validity)
				.withSubject(username)
				.withIssuer(issuerUrl)
				.sign(algorithm)
				.strip();
	}
	
	private String getRefreshToken(String username, List<String> roles, Date now) {
		Date validityRefreshToken = new Date(now.getTime() + (validityInMilliseconds * 3));
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(now)
				.withExpiresAt(validityRefreshToken)
				.withSubject(username)
				.sign(algorithm)
				.strip();
	}
	
	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = this.userDetailsService
				.loadUserByUsername(decodedJWT.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private DecodedJWT decodedToken(String token) {
		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(alg).build();
		DecodedJWT decodedJWT = verifier.verify(token);
		return decodedJWT;
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		
		// Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWFuZHJvIiwicm9sZXMiOlsiQURNSU4iLCJNQU5BR0VSIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsImV4cCI6MTY1MjcxOTUzOCwiaWF0IjoxNjUyNzE1OTM4fQ.muu8eStsRobqLyrFYLHRiEvOSHAcss4ohSNtmwWTRcY
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}
	
	public boolean validateToken(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		try {
			if (decodedJWT.getExpiresAt().before(new Date())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new InvalidJwtAuthenticationException("Expired or invalid JWT token!");
		}
	}
}