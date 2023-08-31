package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProdcuto {

	public static void main(String[] args) {
		
		registrarProducto();	
		
		EntityManager em = JPAUtils.getEntityManager();		
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		System.out.println(producto.getNombre() +" "+ producto.getPrecio() +" dolares");	
		
		List<Producto> productos = productoDao.consultarTodo();
		productos.forEach(prod -> System.out.println(prod.getDescripción()));
		
		List<Producto> productos1 = productoDao.consultarPorNombre("Xiaomi Redmi");
		productos1.forEach(prod -> System.out.println(prod.getDescripción()));	
		
		List<Producto> productos2 = productoDao.consultarPorNombreDeCategoria("CELULARES");
		productos2.forEach(prod -> System.out.println(prod.getDescripción()));	
		
		BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
		System.out.println("vale: " + precio);
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");		
		Producto celular = new Producto("Xiaomi Redmi", "8GB ram", new BigDecimal("1000"), celulares);
		
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
