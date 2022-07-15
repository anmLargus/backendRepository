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

import com.ap.backendPortfolio.models.Project;
import com.ap.backendPortfolio.services.ProjectService;

@CrossOrigin("*")
@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/api/proyectos")
	public List<Project> getAll() {
		return projectService.traerTodo();
	}
	
	@GetMapping("/api/proyectos/{id}")
	public Project getOne(@PathVariable int id) {
		return projectService.traerUno(id);
	}
	
	@PostMapping("/api/proyectos")
	public boolean create(@RequestBody Project pr) {
		return projectService.crear(pr);
	}
	
	@PutMapping("/api/proyectos/{id}")
	public ResponseEntity<?> update(@RequestBody Project pr, @PathVariable int id) {		
		try {
			pr.setId(id);
			projectService.modificar(pr);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/proyectos/{id}")
	public boolean remove(@PathVariable int id) {
		return projectService.borrar(id);
	}
}
