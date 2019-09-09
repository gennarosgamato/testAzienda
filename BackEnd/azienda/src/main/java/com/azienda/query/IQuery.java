package com.azienda.query;

import java.util.List;
import java.util.Optional;


import com.azienda.model.Dipendente;

public interface IQuery {
	
	public Optional<List<Dipendente>> findAll();

	public Optional<List<Dipendente>> findAllByPage(int pageNumber);
}
