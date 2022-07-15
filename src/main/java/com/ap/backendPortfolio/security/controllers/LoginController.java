package com.ap.backendPortfolio.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.backendPortfolio.security.models.Login;
import com.ap.backendPortfolio.security.models.TokenInfo;
import com.ap.backendPortfolio.security.services.JwtUtilService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService usuarioDetailsService;
	
	@Autowired
	private JwtUtilService jwtUtilService;	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class); // para ver x consola
	
	@PostMapping("/login")
	public ResponseEntity<TokenInfo> authenticate(@RequestBody Login login) {
		logger.info("Autenticando al usuario {}", login.getUsuario());
		
		try {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getUsuario(),
				login.getClave()
				));
		
		final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(login.getUsuario());
		
		final String jwt = jwtUtilService.generateToken(userDetails);
		
		TokenInfo tokenInfo = new TokenInfo(jwt);
		
		return ResponseEntity.ok(tokenInfo);
		
		} catch (BadCredentialsException bce) {
			System.out.println("No autorizado");
			System.out.println(bce.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();			
		}
	}	
}
