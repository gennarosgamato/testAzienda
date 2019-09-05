package com.azienda.test.service;


import com.azienda.test.model.Dipendente;
import com.azienda.test.persistence.IDipendenteRepository;
import com.azienda.test.service.dto.DipendenteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService implements IDipendenteService {

	@Autowired
	private IDipendenteRepository dipRepository;
	
	@Transactional
	public Optional<List<Dipendente>> findAll() {
		return Optional.ofNullable(dipRepository.findAll());
	}

	@Transactional
	public void save(Dipendente dipendente) {
		dipRepository.save(dipendente);
	}




    

}
