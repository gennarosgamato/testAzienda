package com.azienda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.command.ICommand;
import com.azienda.model.Dipendente;
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
	
	
	@Transactional
	public Optional<List<Dipendente>> findAll() {
		return queryRepository.findAll();
	}

	@Transactional
	public void save(Dipendente dipendente) {
		commandRepository.save(dipendente);
	}
	
	@Transactional
	public Optional<List<Dipendente>> findAllByPage(int pageNumber){
		return queryRepository.findAllByPage(pageNumber);
	}

	

   
    

}
