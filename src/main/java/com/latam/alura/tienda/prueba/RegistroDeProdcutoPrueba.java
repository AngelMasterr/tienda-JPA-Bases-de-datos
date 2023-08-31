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

public class RegistroDeProdcutoPrueba {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");		
				
		
		// EntityManager: interfaz que proporciona métodos para realizar operaciones de persistencia
		EntityManager em = JPAUtils.getEntityManager();
						
		// getTransaction().begin(): indica el comienzo de una nueva transacción.
		// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
		// getTransaction().commit(): indica que la transacción se ha completado con éxito y que los cambios realizados, como la inserción de la nueva fila en la tabla, deben ser confirmados en la base de datos.
		// flush(): aplica los cambios en la base de datos pero la transacción no se completa. (es un commit pero si hay un error la transaccion no se confirma)
		// merge(): es cuando tienes una entidad que no está siendo rastreada por el EntityManager, pero deseas que sus cambios se reflejen en la base de datos
		// close(): Esto libera los recursos asociados y finaliza la conexión con la base de datos. Cerrar el EntityManager también finaliza cualquier transacción abierta.
		// clear(): limpia el caché de entidades administradas por el EntityManager, desvinculándolas y permitiendo que se recarguen desde la base de datos si es necesario.
		em.getTransaction().begin();	
		em.persist(celulares);
		em.flush();
		em.clear();
		
		// como se uso el clear, eso limpia el registro por eso es necesario hacer un merge para volver a seleccionarlo
		
		celulares = em.merge(celulares);
		celulares.setNombre("carnes");
		em.flush();
		
		em.remove(celulares);
		em.flush();
		
	}

}
