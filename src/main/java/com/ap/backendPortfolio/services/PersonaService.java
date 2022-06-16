package com.ap.backendPortfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.backendPortfolio.models.Persona;
import com.ap.backendPortfolio.repositories.IPersonaRepository;

@Service
public class PersonaService implements ICrudService<Persona> {

	@Autowired
	IPersonaRepository personaRepo;
	
	@Override
	public List<Persona> traerTodo() {
		// TODO Auto-generated method stub
		return personaRepo.findAll();
	}

	@Override
	public Persona traerUno(long id) {
		// TODO Auto-generated method stub
		return personaRepo.findById(id).orElse(new Persona());
	}
	
	// NO SE DEBERÍA PODER CREAR OTRO USUARIO
	@Override
	public boolean crear(Persona p) {
		// TODO Auto-generated method stub
		personaRepo.save(p);
		return true;
	}

	@Override
	public boolean modificar(Persona p) {
		// TODO Auto-generated method stub
		personaRepo.save(p);
		return false;
	}

	// TODO: NO SE DEBERIA PODER BORRAR AL USUARIO (PERSONA)
	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		try {
			personaRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
	}
	
	// TODO: NO SE DEBERIA PODER BORRAR AL USUARIO (PERSONA)
	@Override
	public boolean borrar(Persona p) {
		try {
			personaRepo.delete(p);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}
	
	
	

}
