package com.azienda.query;

import java.util.List;
import java.util.Optional;


import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;

public interface IQuery {
	
	public Optional<List<Dipendente>> findAll();

	public Optional<Dipendente> findById(int id);

	public Optional<UserDetails> getUtenza(String username, String password);
	

}
