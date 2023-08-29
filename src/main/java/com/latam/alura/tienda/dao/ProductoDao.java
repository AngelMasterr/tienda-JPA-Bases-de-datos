package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDao {
	
	private EntityManager em;

	// constructor
	public ProductoDao(EntityManager em) {		
		this.em = em;
	}
	
	// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
	public void guardar(Producto producto) {
		this.em.persist(producto);		
	}

}
