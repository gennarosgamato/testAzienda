package com.security.service;

import java.util.Optional;

import com.security.model.Utente;

public interface IUserDetailsService {

	
	public Optional<Utente> login (String username, String password);
	
	public void insertUtente(String username,String password);
}
