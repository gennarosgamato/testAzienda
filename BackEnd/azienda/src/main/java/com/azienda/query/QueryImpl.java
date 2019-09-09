package com.azienda.query;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;

@Repository
public class QueryImpl implements IQuery {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<List<Dipendente>> findAll() {
		Query query = entityManager.createQuery("from Dipendente");
		List<Dipendente> listaPersone = query.getResultList();
		return Optional.ofNullable(listaPersone);

	}
	
	@Override	
	public Optional<Dipendente> findById(int id) {
		Query query= entityManager.createQuery("from Dipendente d where d.id= :id");
		query.setParameter("id", id);
		Optional<Dipendente> dipendente=(Optional<Dipendente>) query.getSingleResult();
		return dipendente;	
	}

}
