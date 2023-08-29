package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProdcuto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");		
		Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal("1000"), celulares);			
		
		// EntityManager: interfaz que proporciona métodos para realizar operaciones de persistencia
		EntityManager em = JPAUtils.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProductoDao productoDao = new ProductoDao(em);
		
		// begin(): indica el comienzo de una nueva transacción.
		// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
		// commit(): indica que la transacción se ha completado con éxito y que los cambios realizados, como la inserción de la nueva fila en la tabla, deben ser confirmados en la base de datos.
		// close(): Esto libera los recursos asociados y finaliza la conexión con la base de datos. Cerrar el EntityManager también finaliza cualquier transacción abierta.
		em.getTransaction().begin();	
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);	
		
		em.getTransaction().commit();
		em.close();
		
	}

}
