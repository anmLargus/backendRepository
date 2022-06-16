package com.ap.backendPortfolio.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.backendPortfolio.models.Persona;
import com.ap.backendPortfolio.services.PersonaService;

@CrossOrigin("*")
@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> getAll() {
		return personaService.traerTodo();
	}
	
	@GetMapping("/personas/{id}")
	public Persona getOne(@PathVariable int id) {
		return personaService.traerUno(id);
	}
	
	// HAY UN SOLO USUARIO AL CUAL SE LE PUEDE MODIFICAR
	  @PostMapping("/personas") public boolean create(@RequestBody Persona p) {
	  return personaService.crear(p); }
	 
	
	@PutMapping("/personas/{id}")
	public ResponseEntity<?> update(@RequestBody Persona p, @PathVariable int id) {
		try {
			personaService.modificar(p);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/* NO SE DEBERÍA PODER BORRAR USUARIOS. SOLO MODIFICARLOS
	 * @DeleteMapping("/personas/{id}") public boolean remove(@PathVariable int id)
	 * { return personaService.borrar(id); }
	 */


}
