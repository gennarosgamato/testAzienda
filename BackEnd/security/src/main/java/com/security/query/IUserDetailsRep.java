 package com.security.query;

import java.util.Optional;

import com.security.model.Utente;

public interface IUserDetailsRep {

	public Optional<Utente> login(String username, String password);
	
	public void insertUtente(String username, String password);

	public Utente loadUserByUsername(String username);
	
}
