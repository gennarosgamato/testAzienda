package com.azienda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.model.Dipendente;
import com.azienda.service.IDipendenteService;
import com.azienda.service.request.DipendenteRequest;
import com.azienda.service.response.ErrorResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QueryContoller {

	@Autowired
	private IDipendenteService dipendenteService;

	static final Logger LOGGER = LogManager.getLogger(QueryContoller.class.getName());

	@RequestMapping(value = "/dipendenti", method = RequestMethod.GET)
	public ResponseEntity<?> ricercaTuttiIDipendenti() {
		LOGGER.error("ERROR LOGGER TEST");
		try {
			return buildResponse(dipendenteService.findAll());
		} catch (Exception e) {
			// LOG!
			e.printStackTrace();
			return buildErrorResponse("ERR-02",
					"Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/findCriteria/{page}", method = RequestMethod.GET)
    public ResponseEntity<?> findCriteria(@RequestBody Dipendente dipendente, @PathVariable("page") int pageNumber){
		String criteria;
		criteria=(dipendente.getNome()==null)?"cognome":"nome";
		try{
			switch (criteria) {
			case "nome":
				 return buildResponse(dipendenteService.findWPagination(dipendente.getNome(), pageNumber));	
			case "cognome":
				 return buildResponse(dipendenteService.findWPagination(pageNumber,dipendente.getCognome()));
			default:
				 return buildResponse(dipendenteService.findWPagination(pageNumber));
			}
        }catch (Exception e){
            //LOG!
        	e.printStackTrace();
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
    }

	
	private ErrorResponse buildErrorResponse(String codice, String messaggio) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setCode(codice);
		errorResponse.setMessage(messaggio);
		return errorResponse;
	}

	private ResponseEntity<?> buildResponse(Optional<?> optional) {
		if (optional.isPresent()) {
			return new ResponseEntity(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
	}

}
