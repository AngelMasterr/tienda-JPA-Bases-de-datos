package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;

import net.bytebuddy.asm.Advice.Return;

public class PedidoDao {
	
	private EntityManager em;

	// constructor
	public PedidoDao(EntityManager em) {		
		this.em = em;
	}
	
	// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);		
	}
	
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	
	public void remover(Pedido pedido) {
		pedido = this.em.merge(pedido);
		this.em.remove(pedido);
	}	
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	} 
	
	public List<Pedido> consultarTodo(){
		String jpql = "SELECT P FROM Pedido AS P";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}
	
	public List<Pedido> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Pedido AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql,Pedido.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public List<Pedido> consultarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT P FROM Pedido AS P WHERE P.categoria.nombre =: nombre";
		return em.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
	}	
	
	public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
		String jpql = "SELECT P.precio FROM Pedido AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
	

}
