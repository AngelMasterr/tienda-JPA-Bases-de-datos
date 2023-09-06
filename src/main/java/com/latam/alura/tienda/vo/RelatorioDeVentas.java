package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVentas {
	
	private String nombreProducto;
	private Long cantidadProducto;
	private LocalDate FechaDeUltimaVenta;
	
	public RelatorioDeVentas(String nombreProducto, Long cantidadProducto, LocalDate fechaDeUltimaVenta) {
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		FechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	public String getNombreProducto() { 
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Long cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public LocalDate getFechaDeUltimaVenta() {
		return FechaDeUltimaVenta;
	}
	public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
		FechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioDeVentas [nombreProducto=" + nombreProducto + ", cantidadProducto=" + cantidadProducto
				+ ", FechaDeUltimaVenta=" + FechaDeUltimaVenta + "]";
	}	

}
