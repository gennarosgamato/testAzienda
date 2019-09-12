package com.azienda.query;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;

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
	
	@Override
	public Optional<UserDetails> getUtenza(String username,String password){
		Query query= entityManager.createQuery("from UserDetails u where u.username= :username AND u.password= :password");
		query.setParameter("username",username);
		query.setParameter("password", password);
		List<UserDetails> result= query.getResultList();
		return result.isEmpty() ? Optional.empty() : Optional.of( result.get(0) );
	}
}
