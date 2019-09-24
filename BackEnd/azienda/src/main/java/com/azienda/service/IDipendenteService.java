package com.azienda.service;

import java.util.List;
import java.util.Optional;

import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;

public interface IDipendenteService {
//Query
	public Optional<List<Dipendente>> findAll();
	
	public Optional<Dipendente> findById(int id);
	
//Pagination	
	public Optional<List<Dipendente>> findWPagination(String nome, int pageNumber);
	
	public Optional<List<Dipendente>> findWPagination(int pageNumber, String cognome);

	public Optional<List<Dipendente>> findWPagination(int pageNumber);
	
//Command 
	public void save(Dipendente dipendente);
	
	public void updateDipendente(Dipendente dipendente);
	
	public void removeDipendente(Dipendente dipendente);
	
	public void addUtenza(UserDetails u);
}
