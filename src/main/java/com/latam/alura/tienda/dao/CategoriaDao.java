package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	// constructor
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);		
	}
	
	private void actualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	private void remover(Categoria categoria) {
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}

}
