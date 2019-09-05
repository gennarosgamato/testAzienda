package com.azienda.test.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.azienda.test.model.Azienda;

public interface IAziendaRepository extends PagingAndSortingRepository<Azienda, Long> {
}
