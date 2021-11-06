package com.sarbajit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private JwtUtils jwtUtils;


	public String convertObjectToJson(Object object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return request.getRequestURI().startsWith("/app/auth");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=null,token=null;
		final String authHeader = request.getHeader("Authorization");
		final String path = request.getRequestURI();
//		System.out.println(path);

		try {
			if (authHeader!=null && authHeader.startsWith("Bearer ")) {
				token = authHeader.substring(7);
				userName = jwtUtils.getUsernameFromToken(token);
				System.out.println("Username from Token " + userName);
				if (userName==null) throw new Exception("Invalid Token, Can't get any username.");
			} else {
				throw new BadCredentialsException("Unsupported authentication Header '" + authHeader  + "'");
			}

			if (SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

				if (jwtUtils.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken upAt = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					upAt.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(upAt);
					// Next
					filterChain.doFilter(request, response);
				}
			}
		}
		catch (MalformedJwtException e ) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getWriter().write(convertObjectToJson(new ErrorResponse("Malformed JWT.", 404)));
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		catch (Exception e ) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getWriter().write(convertObjectToJson(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value())));
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}
}