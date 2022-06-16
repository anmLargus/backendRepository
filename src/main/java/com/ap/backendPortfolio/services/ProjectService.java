package com.ap.backendPortfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.backendPortfolio.models.Project;
import com.ap.backendPortfolio.repositories.IProjectRepository;

@Service
public class ProjectService implements ICrudService<Project>{
	@Autowired
	IProjectRepository projectRepo;

	@Override
	public List<Project> traerTodo() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public Project traerUno(long id) {
		// TODO Auto-generated method stub
		return projectRepo.findById(id).orElse(new Project());
	}

	@Override
	public boolean crear(Project pr) {
		// TODO Auto-generated method stub
		projectRepo.save(pr);
		return true;
	}

	@Override
	public boolean modificar(Project pr) {
		// TODO Auto-generated method stub
		projectRepo.save(pr);
		return false;
	}

	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		try {
			projectRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}		
	}

	@Override
	public boolean borrar(Project pr) {
		// TODO Auto-generated method stub
		try {
			projectRepo.delete(pr);
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}		
	}
}
