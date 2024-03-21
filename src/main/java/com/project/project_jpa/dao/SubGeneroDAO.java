/**
 * 
 */
package com.project.project_jpa.dao;

import java.util.List;

import com.project.project_jpa.entity.SubGenero;

/**
 * Interface DAO que realiza el CRUD con JPA para la tabla de subgenero
 */
public interface SubGeneroDAO {
	
	/**
	 * Método que permite guardar un subgenero
	 * @param subGenero {@link SubGenero} objeto a guardar
	 */
	void guardar(SubGenero subGenero);
	
	/**
	 * Método que permite actualizar un subgenero
	 * @param subGenero {@link SubGenero} objeto a actualizar
	 */
	void actualizar(SubGenero subGenero);
	
	/**
	 * Método que permite eliminar un subgenero por su identificador
	 * @param id {@link Long} identificador del subgenero a eliminar
	 */
	void eliminar(Long id);
	
	/**
	 * Método que permite consultar la lista de subgeneros
	 * @param subGenero {@link List} Lista de subgeneros consultados
	 */
	List<SubGenero> consultar();
	
	/**
	 * Método que permite consultar un SubGenero a partir de su identificador
	 * @param subGenero {@link Long} identificador del subgenero a consultar
	 * @return {@link SubGenero}
	 */
	SubGenero consultarById(Long id);
}
