package com.azienda.test.service;

import com.azienda.test.model.Dipendente;
import com.azienda.test.service.dto.DipendenteDTO;

import java.util.List;
import java.util.Optional;

public interface IAziendaService {

    Optional<List<Dipendente>> ricercaDipendenti();

    Optional<List<Dipendente>> ricercaDipendenti(DipendenteDTO dto);

    Optional<Dipendente> ricercaDipendente(Long idDipendente);
}
