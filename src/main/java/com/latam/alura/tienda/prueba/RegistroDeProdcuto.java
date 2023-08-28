package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProdcuto {

	public static void main(String[] args) {
		
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripción("telefono usado");
		celular.setPrecio(new BigDecimal(1000));
		
		// EntityManagerFactory: Es una factoría que se encarga de crear instancias de EntityManager
		// EntityManager: Es una interfaz que proporciona métodos para realizar operaciones de persistencia, como crear, leer, actualizar y eliminar entidades en la base de datos.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = factory.createEntityManager();
		
		// begin(): indica el comienzo de una nueva transacción.
		// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
		// commit(): indica que la transacción se ha completado con éxito y que los cambios realizados, como la inserción de la nueva fila en la tabla, deben ser confirmados en la base de datos.
		// close(): Esto libera los recursos asociados y finaliza la conexión con la base de datos. Cerrar el EntityManager también finaliza cualquier transacción abierta.
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
		
	}

}
