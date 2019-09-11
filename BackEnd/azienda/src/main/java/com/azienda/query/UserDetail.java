package com.azienda.query;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.azienda.model.UserDetails;

public class UserDetail implements IUserDetails{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public boolean login(UserDetails user) {
		return entityManager.contains(user);
	}

	
}
