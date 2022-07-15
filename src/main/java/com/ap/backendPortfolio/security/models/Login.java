package com.ap.backendPortfolio.security.models;

import java.io.Serializable;

public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String clave;

	//Constructor
	public Login(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	//Getters y Setters
	public String getUsuario() {
		return usuario;
	}

	public void setEmail(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
