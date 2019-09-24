package com.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

import com.security.model.Utente;

public interface JwtUserDetailsService {

	
	public Optional<Utente> login (String username, String password);
	
	public void insertUtente(String username,String password);

	public Utente loadUserByUsername(String username);
}
