package com.ap.backendPortfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.backendPortfolio.models.Job;
import com.ap.backendPortfolio.repositories.IJobRepository;

@Service
public class JobService implements ICrudService<Job> {
	@Autowired
	IJobRepository jobRepo;

	@Override
	public List<Job> traerTodo() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public Job traerUno(long id) {
		// TODO Auto-generated method stub
		return jobRepo.findById(id).orElse(new Job());
	}

	@Override
	public boolean crear(Job j) {
		// TODO Auto-generated method stub
		jobRepo.save(j);
		return true;
	}

	@Override
	public boolean modificar(Job j) {
		// TODO Auto-generated method stub
		jobRepo.save(j);
		return false;
	}

	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		try {
			jobRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}	

	@Override
	public boolean borrar(Job j) {
		// TODO Auto-generated method stub
		try {
			jobRepo.delete(j);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}		
	}
}
