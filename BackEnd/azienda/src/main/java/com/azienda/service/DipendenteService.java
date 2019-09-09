package com.azienda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.command.ICommand;
import com.azienda.model.Dipendente;
import com.azienda.query.IPagination;
import com.azienda.query.IQuery;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
public class DipendenteService implements IDipendenteService {

	@Autowired
	private IQuery queryRepository;
	
	@Autowired
	private ICommand commandRepository;
	
	@Autowired
	private IPagination iPagination;
	
	
	@Transactional
	public Optional<List<Dipendente>> findAll() {
		return queryRepository.findAll();
	}

	@Transactional
	public void save(Dipendente dipendente) {
		commandRepository.save(dipendente);
	}
	
	@Transactional
	public Optional<List<Dipendente>> findWPagination(String nome,int pageNumber){
		return iPagination.findWPagination(nome,pageNumber);
	}
	@Transactional
	public Optional<List<Dipendente>> findWPagination(int pageNumber, String cognome){
		return iPagination.findWPagination(pageNumber,cognome);
	}
	
	@Transactional
	public Optional<List<Dipendente>> findWPagination(int pageNumber){
		return iPagination.findWPagination(pageNumber);
	}

	

   
    

}
