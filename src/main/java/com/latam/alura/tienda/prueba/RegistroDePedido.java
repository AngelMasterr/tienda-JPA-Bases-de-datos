package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ClienteDao;
import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.modelo.itemsPedido;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.vo.RelatorioDeVentas;

public class RegistroDePedido {

	public static void main(String[] args) {
		
		registrarProducto();	
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);		
		
		Cliente cliente = new Cliente("Juan", "C.123456");
		Pedido pedido = new Pedido(cliente);
		pedido.agregarItems(new itemsPedido(5, producto, pedido));
		
		em.getTransaction().begin();
		
		clienteDao.guardar(cliente);
		pedidoDao.guardar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotal = pedidoDao.valorTotalVendido();
		System.out.println("Valor total: " + valorTotal);
		
		List<RelatorioDeVentas> relatorio= pedidoDao.relatorioDeVentasVO();
		
		relatorio.forEach(System.out::println); 
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");		
		Producto celular = new Producto("Xiaomi Redmi", "8GB ram", new BigDecimal("1200"), celulares);
		
		// EntityManager: interfaz que proporciona métodos para realizar operaciones de persistencia
		EntityManager em = JPAUtils.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProductoDao productoDao = new ProductoDao(em);
						
		// getTransaction().begin(): indica el comienzo de una nueva transacción.
		// persist(): llevar un objeto en memoria y lo almacena como una fila nueva en la base de datos
		// getTransaction().commit(): indica que la transacción se ha completado con éxito y que los cambios realizados, como la inserción de la nueva fila en la tabla, deben ser confirmados en la base de datos.
		// flush(): aplica los cambios en la base de datos pero la transacción no se completa. (es un commit pero si hay un error la transaccion no se confirma)
		// merge(): es cuando tienes una entidad que no está siendo rastreada por el EntityManager, pero deseas que sus cambios se reflejen en la base de datos
		// close(): Esto libera los recursos asociados y finaliza la conexión con la base de datos. Cerrar el EntityManager también finaliza cualquier transacción abierta.
		// clear(): limpia el caché de entidades administradas por el EntityManager, desvinculándolas y permitiendo que se recarguen desde la base de datos si es necesario.
		em.getTransaction().begin();	

		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}




