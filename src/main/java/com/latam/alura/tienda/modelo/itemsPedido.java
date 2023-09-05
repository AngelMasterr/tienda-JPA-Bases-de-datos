package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "itemsPedido")
public class itemsPedido {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	private BigDecimal precioUnitario;
	@ManyToOne
	private Producto producto;
	@ManyToOne
	private Pedido pedido;
		
	// constructor default
	public itemsPedido() {}
	
	//constructor
	public itemsPedido(Integer cantidad, Producto producto, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
		this.precioUnitario = producto.getPrecio();
	}
	//getters and setters
	public Long getId() {
		return id;
	}	
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public Producto getProducto() {
		return producto;		
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getValor() {
		return this.precioUnitario.multiply(new BigDecimal(this.cantidad));
	}	
	
}
