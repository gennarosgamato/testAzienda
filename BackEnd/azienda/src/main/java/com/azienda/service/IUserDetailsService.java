package com.azienda.service;

import java.util.Optional;

import com.azienda.model.UserDetails;

public interface IUserDetailsService {

	
	public Optional<UserDetails> login (String username, String password);
}
