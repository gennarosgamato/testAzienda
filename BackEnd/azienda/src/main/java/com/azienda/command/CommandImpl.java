package com.azienda.command;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;

@Repository
public class CommandImpl implements ICommand {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Dipendente dipendente) {
		entityManager.persist(dipendente);
		entityManager.flush();
	}

	@Override
	public void updateDipendente(Dipendente dipendente) {
		entityManager.merge(dipendente);
		entityManager.flush();
	}

	@Override
	public void removeDipendente(Dipendente dipendente) {
		entityManager.remove(entityManager.contains(dipendente) ? dipendente : entityManager.merge(dipendente));
	}
	
	
	
	@Override
	public void addUtenza(UserDetails u) {
		entityManager.persist(u);
		entityManager.flush();
	}

}
