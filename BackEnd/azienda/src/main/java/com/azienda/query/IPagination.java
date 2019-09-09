package com.azienda.query;

import java.util.List;
import java.util.Optional;

import com.azienda.model.Dipendente;

public interface IPagination {

	public Optional<List<Dipendente>> findWPagination(String nome, int page);
	
	public Optional<List<Dipendente>> findWPagination(int page, String cognome);
	
	public Optional<List<Dipendente>> findWPagination(int page);
	
	
}
