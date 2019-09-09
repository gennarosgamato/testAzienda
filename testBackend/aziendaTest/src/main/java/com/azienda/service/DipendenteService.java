package com.azienda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.model.Dipendente;
import com.azienda.persistence.IDipendenteDao;
import com.azienda.service.dto.DipendenteDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService implements IDipendenteService {

	@Autowired
	private IDipendenteDao dipRepository;
	
	@Transactional
	public Optional<List<Dipendente>> findAll() {
		return dipRepository.findAll();
	}

	@Transactional
	public void save(Dipendente dipendente) {
		dipRepository.save(dipendente);
	}




    

}