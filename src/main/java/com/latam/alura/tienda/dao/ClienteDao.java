package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Cliente;

import net.bytebuddy.asm.Advice.Return;

public class ClienteDao {
	
	private EntityManager em;

	// constructor
	public ClienteDao(EntityManager em) {		
		this.em = em;
	}
	
	// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
	public void guardar(Cliente cliente) {
		this.em.persist(cliente);		
	}
	
	public void actualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente = this.em.merge(cliente);
		this.em.remove(cliente);
	}	
	
	public Cliente consultaPorId(Long id) {
		return em.find(Cliente.class, id);
	} 
	
	public List<Cliente> consultarTodo(){
		String jpql = "SELECT P FROM Cliente AS P";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public List<Cliente> consultarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT P FROM Cliente AS P WHERE P.categoria.nombre =: nombre";
		return em.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		String jpql = "SELECT P.precio FROM Cliente AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
	

}
