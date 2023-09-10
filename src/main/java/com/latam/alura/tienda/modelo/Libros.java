package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "libros")
public class Libros extends Producto{
	
	private String autor;
	private Integer Paginas;
	
	// constructor default
	public Libros() {
	}
	// constructor
	public Libros(String autor, Integer paginas) {
		this.autor = autor;
		Paginas = paginas;
	}
	// getters and setters
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getPaginas() {
		return Paginas;
	}
	public void setPaginas(Integer paginas) {
		Paginas = paginas;
	}
	
	
	
	

}
