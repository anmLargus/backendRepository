package com.ap.backendPortfolio.services;

import java.util.List;

// import com.ap.backendPortfolio.models.Educacion;

public interface ICrudService<T> {
	
	public List<T> traerTodo();
	public T traerUno(long id);
	public boolean crear(T entity);
	public boolean modificar(T entity);
	public boolean borrar(long entity);
	public boolean borrar(T entity);

}
