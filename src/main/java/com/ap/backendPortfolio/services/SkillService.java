package com.ap.backendPortfolio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.backendPortfolio.models.Skill;
import com.ap.backendPortfolio.repositories.ISkillRepository;

@Service
public class SkillService implements ICrudService<Skill>{
	
	@Autowired
	ISkillRepository skillRepo;

	@Override
	public List<Skill> traerTodo() {
		// TODO Auto-generated method stub
		return skillRepo.findAll();
	}

	@Override
	public Skill traerUno(long id) {
		// TODO Auto-generated method stub
		return skillRepo.findById(id).orElse(new Skill());
	}

	@Override
	public boolean crear(Skill s) {
		// TODO Auto-generated method stub
		skillRepo.save(s);
		return true;
	}

	@Override
	public boolean modificar(Skill s) {
		// TODO Auto-generated method stub
		skillRepo.save(s);
		return false;
	}

	@Override
	public boolean borrar(long id) {
		// TODO Auto-generated method stub
		try {
			skillRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean borrar(Skill s) {
		// TODO Auto-generated method stub
		try {
			skillRepo.delete(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
