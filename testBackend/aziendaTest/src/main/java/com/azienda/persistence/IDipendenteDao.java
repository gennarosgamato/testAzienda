package com.azienda.persistence;

import java.util.List;
import java.util.Optional;

import com.azienda.model.Dipendente;

public interface IDipendenteDao{
	
	public void save(Dipendente dipendente);
	
	public Optional<List<Dipendente>> findAll();
}
