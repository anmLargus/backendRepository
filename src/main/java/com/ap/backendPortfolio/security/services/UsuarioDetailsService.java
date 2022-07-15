package com.ap.backendPortfolio.security.services;

import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Map<String, String> usuarios = Map.of("usuario", "USER", "anm@admin.com", "ADMIN" );
		
		var rol = usuarios.get(username);
		
		if (rol != null) {
			User.UserBuilder userBuilder = User.withUsername(username);
			String encryptedPassword = "$2a$10$PPRj2W3m3mkGwHQQ.V5nL.gbDcmHGUulVemn/DwqcqevgDpoZmgVa" ;
			userBuilder.password(encryptedPassword).roles(rol);
			return userBuilder.build();
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
