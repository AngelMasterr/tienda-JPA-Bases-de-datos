package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

// @Entity: marca una clase Java como una entidad persistente, los objetos de esta clase serán mapeados a registros en una base de datos
// @Table: especifica el nombre de la tabla en la base de datos a la cual la entidad será mapeada.
// @SuppressWarnings("all"): suprime todas las advertencias generadas por el compilador o el entorno de desarrollo (IDE)
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE): especificar la estrategia de herencia que se debe utilizar en una jerarquía de clases cuando se mapean a una base de datos
// crea una única tabla en la base de datos para representar todas las tablas en las clases en la jerarquía de herencia
@SuppressWarnings("all")
@Entity
@Table(name="productos")
@NamedQuery(name = "Producto.consultaDePrecio", query = "SELECT P.precio FROM Producto AS P WHERE P.nombre =: nombre")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {
	
	// @Id: Indica que este campo es la clave primaria de la entidad 
	// @GeneratedValue(strategy = GenerationType.IDENTITY): genera automáticamente los valores para la clave primarias
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripción;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now();
	// @ManyToOne :representar una relación en la que varios registros de una tabla (Categoria) se asocian con un solo 
	// registro en otra tabla (Producto).
	@ManyToOne (fetch = FetchType.LAZY)
	private Categoria categoria;
	
	
	// Constructor
	public Producto(String nombre, String descripción, BigDecimal precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripción = descripción;
		this.precio = precio;
		this.categoria = categoria;
	}
	// Constructor default
	public Producto() {
	}

	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}		
	
}
