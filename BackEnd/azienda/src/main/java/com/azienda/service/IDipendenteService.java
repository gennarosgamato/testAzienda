package com.azienda.service;

import java.util.List;
import java.util.Optional;

import com.azienda.model.Dipendente;

public interface IDipendenteService {

	public Optional<List<Dipendente>> findAll();

	public void save(Dipendente dipendente);
	
	public Optional<List<Dipendente>> findWPagination(String nome, int pageNumber);
	
	public Optional<List<Dipendente>> findWPagination(int pageNumber, String cognome);

	public Optional<List<Dipendente>> findWPagination(int pageNumber);
}
