package com.ap.backendPortfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nombre;
	private String apellido;
	private String email;
	private String parrafoPresentacion;
	private String frasePresentacion;
	private String linkFoto;
	private String linkedin;
	private String github;
	private String redSocial;
	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param parrafoPresentacion
	 * @param frasePresentacion
	 * @param linkFoto
	 * @param linkedin
	 * @param github
	 * @param redSocial
	 */
	public Persona(long id, String nombre, String apellido, String email, String parrafoPresentacion,
			String frasePresentacion, String linkFoto, String linkedin, String github, String redSocial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.parrafoPresentacion = parrafoPresentacion;
		this.frasePresentacion = frasePresentacion;
		this.linkFoto = linkFoto;
		this.linkedin = linkedin;
		this.github = github;
		this.redSocial = redSocial;
	}
	
	/**
	 * 
	 */
	public Persona() {
		super();
	}
	//Getters & Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParrafoPresentacion() {
		return parrafoPresentacion;
	}
	public void setParrafoPresentacion(String parrafoPresentacion) {
		this.parrafoPresentacion = parrafoPresentacion;
	}
	public String getFrasePresentacion() {
		return frasePresentacion;
	}
	public void setFrasePresentacion(String frasePresentacion) {
		this.frasePresentacion = frasePresentacion;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getRedSocial() {
		return redSocial;
	}
	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}
	
	
	
	
	
	

}
