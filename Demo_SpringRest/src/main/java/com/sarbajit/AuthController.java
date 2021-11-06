package com.sarbajit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController{
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping(value="/login", consumes="application/json")
	public ResponseEntity<?> login(@RequestBody AuthRequest req) throws Exception{
		try {
			Authentication result = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(req.getUserName(), req.getPassWord())
					);

			System.out.println(result.getDetails());
			System.out.println(result.isAuthenticated());
		} catch (BadCredentialsException e) {
			// TODO: handle exception
//			throw new BadCredentialsException("Something is broken");
			return ResponseEntity.ok(new ErrorResponse("Authentication Failed.", 400));
		}
		
		final UserDetails user = userDetailsService.loadUserByUsername(req.getUserName());
		
		final String token = jwtUtils.generateToken(user);
		
		return ResponseEntity.ok(new AuthResponse(token));		
		
		
	}
	
	@PostMapping(value="/signup", consumes="application/json")
	public ResponseEntity<User> signup(@RequestBody AuthRequest authReq) throws Exception {
		String userName=authReq.getUserName(),password=authReq.getPassWord();
		User newU = this.userRepo.addNewUser(userName, password);
		
		return ResponseEntity.ok(newU);
	}
	
	
	
	
	
	
	
	
	
	
}
