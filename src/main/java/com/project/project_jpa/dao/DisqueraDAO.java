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
}
