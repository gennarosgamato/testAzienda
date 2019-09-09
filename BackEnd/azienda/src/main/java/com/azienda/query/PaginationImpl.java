package com.azienda.query;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;

@Repository
public class PaginationImpl implements IPagination {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Optional<List<Dipendente>> findWPagination(String nome, int pageNumber) {
		int pageSize = 10;
		int itemNumber = (pageSize * pageNumber) - pageSize;
		List<Dipendente> listByCriteria = null;

		Query query = entityManager.createQuery("from Dipendente d where d.nome = :nome");
		query.setFirstResult(itemNumber)
			 .setMaxResults(pageSize)
			 .setParameter("nome", nome);
		
		listByCriteria = query.getResultList();
		return Optional.ofNullable(listByCriteria);
	}
	

	@Override
	public Optional<List<Dipendente>> findWPagination(int pageNumber, String cognome) {
		int pageSize = 10;
		int itemNumber = (pageSize * pageNumber) - pageSize;
		List<Dipendente> listByCriteria = null;

		Query query = entityManager.createQuery("from Dipendente d where d.cognome = :cognome");
		query.setFirstResult(itemNumber)
			 .setMaxResults(pageSize)
			 .setParameter("cognome", cognome);

		listByCriteria = query.getResultList();
		return Optional.ofNullable(listByCriteria);
	}


	@Override
	public Optional<List<Dipendente>> findWPagination(int pageNumber) {
		int pageSize = 10;
		int itemNumber = (pageSize * pageNumber) - pageSize;
		List<Dipendente> listByCriteria = null;

		Query query = entityManager.createQuery("from Dipendente d");
		query.setFirstResult(itemNumber)
			 .setMaxResults(pageSize);

		listByCriteria = query.getResultList();
		return Optional.ofNullable(listByCriteria);
	}

}
