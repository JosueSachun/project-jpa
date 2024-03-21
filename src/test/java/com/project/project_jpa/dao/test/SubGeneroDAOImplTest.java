/**
 * 
 */
package com.project.project_jpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.project_jpa.dao.impl.SubGeneroDAO;
import com.project.project_jpa.dao.impl.SubGeneroDAOImpl;
import com.project.project_jpa.entity.Genero;
import com.project.project_jpa.entity.SubGenero;

/**
 * Clase TEST para comprobar funcionamiento de los métodos del CRUD del subgenero
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.project.project_jpa.dao.impl.SubGeneroDAOImpl#guardar(com.project.project_jpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Hard Core1");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Rock nuevo1");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		
		subGenero.setGenero(genero);
		
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.project.project_jpa.dao.impl.SubGeneroDAOImpl#actualizar(com.project.project_jpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(7L);
		subGeneroConsultado.setDescripcion("Prueba Rock Metal");
		subGeneroConsultado.getGenero().setDescripcion("ROCK DE PRUEBA GENERO");
		
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	}

	/**
	 * Test method for {@link com.project.project_jpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(9L);
	}

	/**
	 * Test method for {@link com.project.project_jpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados =  this.subGeneroDAO.consultar();
		
		assertTrue(subGenerosConsultados.size() > 0);
		
		for (SubGenero subGenero : subGenerosConsultados) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Género: " + subGenero.getGenero().getDescripcion());
		}
	}

	/**
	 * Test method for {@link com.project.project_jpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
