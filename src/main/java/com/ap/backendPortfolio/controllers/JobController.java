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

import com.ap.backendPortfolio.models.Job;
import com.ap.backendPortfolio.services.JobService;

@CrossOrigin("*")
@RestController
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/jobs")
	public List<Job> getAll() {
		return jobService.traerTodo();
	}
	
	@GetMapping("/jobs/{id}")
	public Job getOne(@PathVariable int id) {
		return jobService.traerUno(id);
	}
	
	@PostMapping("/jobs")
	public boolean create(@RequestBody Job j) {
		return jobService.crear(j);
	}
	

	@PutMapping("/jobs/{id}")
	public ResponseEntity<?> update(@RequestBody Job j, @PathVariable int id) {
		try {
			//Job existJob = jobService.traerUno(id);  /*EN TUTORIAL ESTABAN ESTAS DOS LÍNEAS DE CÓDIGO (?)*/
			//j.setId(id);
			jobService.modificar(j);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/jobs/{id}")
	public boolean remove(@PathVariable int id) {
		return jobService.borrar(id); 
	}

}
