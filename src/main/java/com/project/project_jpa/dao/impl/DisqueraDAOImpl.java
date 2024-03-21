/**
 * 
 */
package com.project.project_jpa.dao.impl;

import java.util.List;

import com.project.project_jpa.dao.DisqueraDAO;
import com.project.project_jpa.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Clase que implementa las transacciones para la tabla de Disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("jpa-hibernate-mysql");

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		/**
		 * Siempre que se realice una modificación a una base de datos se debe utilizar
		 * getTransaction para habilitar la transacción.
		 */
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		/**
		 * Siempre que se realice una modificación a una base de datos se debe utilizar
		 * getTransaction para habilitar la transacción.
		 */
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada =  em.find(Disquera.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(disqueraConsultada);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Disquera> consultar() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
	}

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultado =  em.find(Disquera.class, id);
		
		if (disqueraConsultado == null) {
			throw new EntityNotFoundException("La disquera con id:" + id + " no se encontró.");
		}
		return disqueraConsultado;
	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc");
		queryDisquera.setParameter("desc", descripcion);
		
		return queryDisquera.getSingleResult();
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera =  (TypedQuery<Disquera>) em.createNativeQuery("SELECT * FROM disquera WHERE descripcion = :desc", Disquera.class);
		queryDisquera.setParameter("desc", descripcion);
		
		return queryDisquera.getSingleResult();
	}
	
	

}
