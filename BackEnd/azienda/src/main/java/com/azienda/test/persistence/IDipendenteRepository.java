package com.azienda.test.persistence;



import org.springframework.data.jpa.repository.JpaRepository;

import com.azienda.test.model.Dipendente;

public interface IDipendenteRepository extends JpaRepository<Dipendente,Long>{
	
}
