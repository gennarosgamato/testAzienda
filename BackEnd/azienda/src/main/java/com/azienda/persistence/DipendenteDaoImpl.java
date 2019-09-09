package com.azienda.persistence;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;

import springfox.documentation.spring.web.json.Json;

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
		List<Dipendente> listaPersone = query.getResultList();
		return Optional.ofNullable(listaPersone);

	}

	@Override
	public Optional<List<Dipendente>> findAllByPage(int pageNumber) {
		int pageSize=10;
		int itemNumber= (pageSize*pageNumber) - pageSize;
		
		List<Dipendente> listByCriteria=null;
		
		Query query = entityManager.createQuery("from Dipendente d");
				query.setFirstResult(itemNumber)
					 .setMaxResults(pageSize);
				
				listByCriteria=query.getResultList();
			
		return  Optional.ofNullable(listByCriteria);
	}

}
