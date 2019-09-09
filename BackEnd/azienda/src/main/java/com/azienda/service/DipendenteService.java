package com.azienda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.azienda.model.Dipendente;
import com.azienda.persistence.IDipendenteDao;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

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
	
	@Transactional
	public Optional<List<Dipendente>> findAllByPage(int pageNumber){
		return dipRepository.findAllByPage(pageNumber);
	}

	

   
    

}
