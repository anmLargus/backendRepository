package com.ap.backendPortfolio.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.backendPortfolio.models.Persona;
import com.ap.backendPortfolio.utils.Auth;
import com.ap.backendPortfolio.utils.Login;
import com.ap.backendPortfolio.utils.Response;
import com.auth0.jwt.exceptions.JWTCreationException;

@CrossOrigin("*")
@RestController
public class MainController {
	
	@PostMapping("/login") // Debo crear una clase persona(seria el usuario) o debo replicar este código en cada controller?
	public Response<Persona> login(@RequestBody Login p) {
		try {
			// Validar credenciales
			String token = Auth.generateJWT(p);			
			Response<Persona> r = new Response<Persona>();			
			r.msg = "auth OK";
			r.code = 1;
			r.token = token;			
			return r;					
		} catch(IllegalArgumentException e) {
			Response<Persona> r = new Response<Persona>();
			r.token = "askdjañldskfj";// ¿QUE TOKEN DEBO COLOCAR?
			r.msg = "Error IllegalArgumentException";			
			return r;
		} catch(JWTCreationException exception) {
			Response<Persona> r = new Response<Persona>();			
			r.msg = "Error 2";			
			return r;
		} catch(Exception e) {
			Response<Persona> r = new Response<Persona>();			
			r.token = "askdjañldskfj";// ¿QUE TOKEN DEBO COLOCAR?
			r.msg = "Error 3";
			
			return r;
		}
	}
	
	//@GetMapping("/listar")  //asi es el ejemplo

}
;