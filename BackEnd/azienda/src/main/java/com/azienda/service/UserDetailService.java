package com.azienda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.azienda.model.UserDetails;
import com.azienda.query.IUserDetails;

public class UserDetailService implements IUserDetails{

	@Autowired
	IUserDetails dipendenteService;
	
	@Override
	public boolean login(UserDetails user) {
		return dipendenteService.login(user);
	}

	
}
