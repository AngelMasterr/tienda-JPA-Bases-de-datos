package com.latam.alura.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity: marca una clase Java como una entidad persistente, los objetos de esta clase serán mapeados a registros en una base de datos
//@Table: especifica el nombre de la tabla en la base de datos a la cual la entidad será mapeada.
@Entity
@Table(name = "categorias")
public class Categoria {
		
	// Crear una clase "CategoriaId" para crear una llave que sea compuesta con nombre y contraseña	
	@ EmbeddedId
	private CategoriaId categoriaId;
		
		
	// constructor default
	public Categoria() {
	}
	// constructor
	public Categoria(String nombre) {
		this.categoriaId = new CategoriaId(nombre, "456");		
	}	

	// getters and setters
	public String getNombre() {
		return categoriaId.getNombre();
	}
	public void setNombre(String nombre) {
		this.categoriaId.setNombre(nombre);
	}
	
}
