package com.azienda.service;

import java.util.List;
import java.util.Optional;

import com.azienda.model.Dipendente;


public interface IDipendenteService {

   public Optional<List<Dipendente>> findAll();
   

	public void save(Dipendente dipendente);
}