package com.ap.backendPortfolio.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ap.backendPortfolio.security.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService usuarioDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()			
			.antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN") // 
			.antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/**").permitAll() // cualquier peticion get es admitida
			.antMatchers("/login/**").permitAll() //todos tienen acceso a login
		/*	.antMatchers("/jobs/**").permitAll()
			.antMatchers("/personas/**").permitAll()
			.antMatchers("/proyectos/**").permitAll()
			.antMatchers("/skills/**").permitAll()*/
			.anyRequest().authenticated() // cualquier otra peticion debe ser autenticada
			.and().cors()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Es sin estado
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//configura de donde se va a extraer la conf de credenciales
		auth.userDetailsService(usuarioDetailsService);
	}
	
	

}
