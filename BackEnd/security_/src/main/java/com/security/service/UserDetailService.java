package com.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.Utente;
import com.security.query.IUserDetails;

@Service
public class UserDetailService implements IUserDetailsService{

	
	@Autowired
	private IUserDetails userDetail;
	
	
	@Transactional
	public Optional<Utente> login (String username, String password){
		return userDetail.login(username, password);
	}


	@Override
	public void insertUtente(String username, String password) {
		userDetail.insertUtente(username, password);
	}

	
}
