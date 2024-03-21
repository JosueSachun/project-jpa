package com.project.project_jpa.dao;

import java.util.List;

import com.project.project_jpa.entity.Disquera;

/**
 * Interface que genera el DAO para las transacciones del CRUD a la tabla Disquera
 */
public interface DisqueraDAO {
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);
	
	/**
	 * Método que permite consultar con JPQL la disquera a partir de una descripción.	
	 * @param descripcion {@link String} descripción de la disquera
	 * @return {@link Disquera} la disquera consultada.
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	/**
	 * Método que permite consultar con SQL nativo la disquera a partir de una descripción
	 * @param descripcion
	 * @return
	 */
	Disquera consultarByDescripcionNative(String descripcion);
}
