package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity: marca una clase Java como una entidad persistente, los objetos de esta clase serán mapeados a registros en una base de datos
//@Table: especifica el nombre de la tabla en la base de datos a la cual la entidad será mapeada.
@Entity
@Table(name = "pedidos")
public class Pedido {
	
	// @Id: Indica que este campo es la clave primaria de la entidad 
	// @GeneratedValue(strategy = GenerationType.IDENTITY): genera automáticamente los valores para la clave primarias
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate fecha = LocalDate.now();
	private BigDecimal valorTotal = new BigDecimal(0);
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<itemsPedido> items = new ArrayList<itemsPedido>();
	
	// constructor default
	public Pedido() {}
	
	// constructor
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void agregarItems(itemsPedido item) {
		item.setPedido(this);
		this.items.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	
	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
		
}
