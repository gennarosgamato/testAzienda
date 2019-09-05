package com.azienda.test.service;

import com.azienda.test.model.Dipendente;
import com.azienda.test.persistence.IAziendaRepository;
import com.azienda.test.persistence.IPersonaleRepository;
import com.azienda.test.service.dto.DipendenteDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AziendaService implements IAziendaService {

    @Autowired
    private IAziendaRepository aziendaRepository;

	@Override
	public Dipendente findDipendente(Dipendente d) {
		
		return null;
	}


    

}
