package com.ap.backendPortfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String tituloProyecto;
	private String descripcionProyecto;
	private String tecnologias;
	private String linkProyecto;
	private String snapshot; // path a la foto o link al proyecto?
	/**
	 * @param id
	 * @param tituloProyecto
	 * @param descripcionProyecto
	 * @param tecnologias
	 * @param linkProyecto
	 * @param snapshot
	 */
	public Project(long id, String tituloProyecto, String descripcionProyecto, String tecnologias, String linkProyecto,
			String snapshot) {
		super();
		this.id = id;
		this.tituloProyecto = tituloProyecto;
		this.descripcionProyecto = descripcionProyecto;
		this.tecnologias = tecnologias;
		this.linkProyecto = linkProyecto;
		this.snapshot = snapshot;
	}
	/**
	 * 
	 */
	public Project() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTituloProyecto() {
		return tituloProyecto;
	}
	public void setTituloProyecto(String tituloProyecto) {
		this.tituloProyecto = tituloProyecto;
	}
	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}
	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}
	public String getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}
	public String getLinkProyecto() {
		return linkProyecto;
	}
	public void setLinkProyecto(String linkProyecto) {
		this.linkProyecto = linkProyecto;
	}
	public String getSnapshot() {
		return snapshot;
	}
	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}
			
}
