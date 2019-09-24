package com.security.query;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.model.Utente;

@Repository
public class UserDetails implements IUserDetails{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public  Optional<Utente>  login(String username, String password) {
		Query query = entityManager.createQuery("from User u where u.username= :username and u.password= :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		Utente utente=new Utente();
		utente=(Utente) query.getSingleResult();		
		return Optional.ofNullable(utente);
	}

	@Override
	public void insertUtente(String username, String password) {
		Utente utente= new Utente();
		utente.setUsername(username);
		utente.setPassword(password);
		entityManager.persist(utente);
	}

	
}
