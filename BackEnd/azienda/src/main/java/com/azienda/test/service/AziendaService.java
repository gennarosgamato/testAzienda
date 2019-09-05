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

    @Autowired
    private IPersonaleRepository personaleRepository;

    @Override
    public Optional<List<Dipendente>> ricercaDipendenti() {
        Iterable<Dipendente> all = personaleRepository.findAll();
        List<Dipendente> tmp = new ArrayList<>();
        all.iterator().forEachRemaining(tmp::add);
        Optional<List<Dipendente>> optional = Optional.of(tmp);
        return optional;
    }

    @Override
    public Optional<List<Dipendente>> ricercaDipendenti(DipendenteDTO dto) {
        Optional<List<Dipendente>> all = personaleRepository.cercaDipendenteByEmail(dto.getNome());
        return all;
    }

    @Override
    public Optional<Dipendente> ricercaDipendente(Long idDipendente) {
        Optional<Dipendente> byId = personaleRepository.findById(idDipendente);
        return byId;
    }
}
