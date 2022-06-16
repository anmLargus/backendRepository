package com.ap.backendPortfolio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String fechaInicio;
	private String fechaFin;
	private String empresa;
	private String posicion;
	//@Lob
	@Column(columnDefinition="LONGTEXT")
	private String descripcion;
	private Boolean esActual;
	/**
	 * @param id
	 * @param anioInicio
	 * @param anioFin
	 * @param empresa
	 * @param posicion
	 * @param descripcion
	 * @param esActual
	 */
	public Job(long id, String fechaInicio, String fechaFin, String empresa, String posicion, String descripcion,
			Boolean esActual) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empresa = empresa;
		this.posicion = posicion;
		this.descripcion = descripcion;
		this.esActual = esActual;
	}
	/**
	 * 
	 */
	public Job() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setAnioFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEsActual() {
		return esActual;
	}
	public void setEsActual(Boolean esActual) {
		this.esActual = esActual;
	}
	
}