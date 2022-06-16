package com.ap.backendPortfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String habilidad;
	private int progress;
	/**
	 * @param id
	 * @param habilidad
	 * @param progress
	 */
	public Skill(long id, String habilidad, int progress) {
		super();
		this.id = id;
		this.habilidad = habilidad;
		this.progress = progress;
	}
	/**
	 * 
	 */
	public Skill() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public Number getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}		
}
