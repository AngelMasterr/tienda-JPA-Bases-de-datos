package com.latam.alura.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{
	
	private String nombre;
	private String pasword;
	
	// constructor default
	public CategoriaId() {
	}
	// constructor
	public CategoriaId(String nombre, String pasword) {
		this.nombre = nombre;
		this.pasword = pasword;
	}
	// getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, pasword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(pasword, other.pasword);
	}
	
	
	
	
	

}
