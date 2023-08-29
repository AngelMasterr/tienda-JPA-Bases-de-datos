package com.latam.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	// EntityManagerFactory: Es una factoría que se encarga de crear instancias de EntityManager
	// EntityManager: Es una interfaz que proporciona métodos para realizar operaciones de persistencia, como crear, leer, actualizar y eliminar entidades en la base de datos.		
	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda");
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();		 
	}

}
