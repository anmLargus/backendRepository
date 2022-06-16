package com.ap.backendPortfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String titulo;
	private int anioFin;
	private String lugar;
	private String descripcion;
	
	
	/**
	 * @param id
	 * @param titulo
	 * @param anioFin
	 * @param lugar
	 * @param descripcion
	 *
	 */
	public Educacion(long id, String titulo, int anioFin, String lugar, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anioFin = anioFin;
		this.lugar = lugar;
		this.descripcion = descripcion;
		
	}
	/**
	 * 
	 */
	public Educacion() {
		super();
	}
	
	/* getters & setters */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnioFin() {
		return anioFin;
	}
	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
