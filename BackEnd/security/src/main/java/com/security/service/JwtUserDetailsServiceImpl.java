package com.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.security.model.Utente;
import com.security.query.IUserDetailsRep;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService{

	
	@Autowired
	private IUserDetailsRep userDetail;
	
	
	@Transactional
	public Optional<Utente> login (String username, String password){
		return userDetail.login(username, password);
	}


	@Transactional
	public void insertUtente(String username, String password) {
		userDetail.insertUtente(username, password);
	}


	@Transactional
	public Utente loadUserByUsername(String username) {
		return userDetail.loadUserByUsername(username);
	}

	
}
