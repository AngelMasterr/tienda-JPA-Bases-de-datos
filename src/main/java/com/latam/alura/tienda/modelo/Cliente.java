package com.latam.alura.tienda.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity: marca una clase Java como una entidad persistente, los objetos de esta clase serán mapeados a registros en una base de datos
//@Table: especifica el nombre de la tabla en la base de datos a la cual la entidad será mapeada.
@Entity
@Table(name = "clientes")
public class Cliente {
	
	// @Id: Indica que este campo es la clave primaria de la entidad 
	// @GeneratedValue(strategy = GenerationType.IDENTITY): genera automáticamente los valores para la clave primarias
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// conectar los datos personales
	@Embedded
	private DatosPersonales datosPersonales;	
	
	// constructor default
	public Cliente() {}

	// constructor
	public Cliente(String nombre, String dni) {
		this.datosPersonales = new DatosPersonales(nombre, dni);		
	}

	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return datosPersonales.getNombre();
	}
	public void setNombre(String nombre) {
		this.datosPersonales.setNombre(nombre);
	}

	public String getDni() {
		return datosPersonales.getDni();
	}
	public void setDni(String dni) {
		this.datosPersonales.setDni(dni);
	}
		
}
