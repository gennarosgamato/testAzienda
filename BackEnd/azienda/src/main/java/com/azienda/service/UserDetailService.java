package com.azienda.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.model.UserDetails;
import com.azienda.query.IQuery;

@Service
public class UserDetailService implements IUserDetailsService{

	
	@Autowired
	private IQuery query;
	
	
	@Transactional
	public Optional<UserDetails> login (String username, String password){
		return query.getUtenza(username, password);
	}

	
}
