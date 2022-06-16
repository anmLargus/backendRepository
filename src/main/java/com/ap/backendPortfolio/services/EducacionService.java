package com.ap.backendPortfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.backendPortfolio.models.Educacion;
import com.ap.backendPortfolio.repositories.IEducacionRepository;

@Service
public class EducacionService implements ICrudService<Educacion> {
	
	@Autowired
	IEducacionRepository educacionRepo;

	@Override
	public List<Educacion> traerTodo() {
		// TODO Auto-generated method stub
		return educacionRepo.findAll();
	}

	@Override
	public Educacion traerUno(long id) {
		// TODO Auto-generated method stub
		return educacionRepo.findById(id).orElse(new Educacion());
	}

	@Override
	public boolean crear(Educacion e) {
		// TODO Auto-generated method stub
		educacionRepo.save(e);
		return true;
	}

	@Override
	public boolean modificar(Educacion e) {
		// TODO Auto-generated method stub
		educacionRepo.save(e);
		return false;
	}

	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		try {
			educacionRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean borrar(Educacion ed) {
		// TODO Auto-generated method stub
		try {
			educacionRepo.delete(ed);
			return true;
		} catch (Exception e){
			return false;
		}
	}	

}
