package com.azienda.test.persistence;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.azienda.test.model.Dipendente;

import java.util.List;
import java.util.Optional;

public interface IPersonaleRepository extends PagingAndSortingRepository<Dipendente, Long> {

    @Query("SELECT d FROM Dipendente d where d.email = :email")
    Optional<List<Dipendente>> cercaDipendenteByEmail(String email);
}
