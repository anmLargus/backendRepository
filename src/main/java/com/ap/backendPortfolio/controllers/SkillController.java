package com.ap.backendPortfolio.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.backendPortfolio.models.Skill;
import com.ap.backendPortfolio.services.SkillService;

@CrossOrigin(origins = "*") //  *Es para evitar el rechazo por CrossDomain*
@RestController
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skills")
	public List<Skill> getAll() {
		return skillService.traerTodo();
	}
	
	@GetMapping("/skills/{id}")
	public Skill getOne(@PathVariable int id) {
		return skillService.traerUno(id);
	}
	
	@PostMapping("/skills")
	public boolean create(@RequestBody Skill s) {
		return skillService.crear(s);
	}
	
	@PutMapping("/skills/{id}")
	public ResponseEntity<?> update(@RequestBody Skill s, @PathVariable int id) {
		try {
			skillService.modificar(s);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/skills/{id}") 
		public boolean remove(@PathVariable int id) {
		return skillService.borrar(id);
	}
}
