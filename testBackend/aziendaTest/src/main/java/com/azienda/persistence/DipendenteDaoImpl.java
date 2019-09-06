package com.azienda.persistence;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;

@Repository
public class DipendenteDaoImpl implements IDipendenteDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Dipendente dipendente) {
		entityManager.persist(dipendente);
		entityManager.flush();
	}

	@Override
	public Optional<List<Dipendente>> findAll() {
		Query query = entityManager.createQuery("from Dipendente");
		List<Dipendente> listaPersone= query.getResultList();
		return Optional.ofNullable(listaPersone);
		
	}
	
	
}
