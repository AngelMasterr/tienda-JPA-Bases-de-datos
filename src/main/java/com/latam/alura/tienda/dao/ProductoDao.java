package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

import net.bytebuddy.asm.Advice.Return;

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
	
	public void actualizar(Producto producto) {
		this.em.merge(producto);
	}
	
	public void remover(Producto producto) {
		producto = this.em.merge(producto);
		this.em.remove(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	} 
	
	public List<Producto> consultarTodo(){
		String jpql = "SELECT P FROM Producto AS P";
		return em.createQuery(jpql, Producto.class).getResultList();
	}
	
	public List<Producto> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public List<Producto> consultarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre =: nombre";
		return em.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {		
		return em.createNamedQuery("Producto.consultaDePrecio", BigDecimal.class) .setParameter("nombre", nombre).getSingleResult();
	}
	

}
