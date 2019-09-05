package com.azienda.test.persistence;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AziendaRepository {
	
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Dipendente> findAll() {
		Query query = entityManager.createQuery("from Persona");
		List<Persona> listaPersone= query.getResultList();
		return listaPersone;
	}


}
