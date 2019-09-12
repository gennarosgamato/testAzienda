package com.azienda.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;
import com.azienda.service.IDipendenteService;
import com.azienda.service.dto.DipendenteDTO;
import com.azienda.service.dto.UserDetailsDTO;
import com.azienda.service.request.DipendenteRequest;
import com.azienda.service.request.UserDetailsRequest;
import com.azienda.service.response.ErrorResponse;

@RestController
public class CommandController {

	@Autowired
    private IDipendenteService dipendenteService;
	
	@RequestMapping(value = "/saveDipendente", method = RequestMethod.POST)
    public void saveDipendente(@RequestBody DipendenteRequest request) {
    	DipendenteDTO dto = request.getDto();
    	Dipendente dipendente = new Dipendente();
    	dipendente.setNome(dto.getNome());
    	dipendente.setCognome(dto.getCognome());
    	dipendente.setEmail(dto.getEmail());
    	
    	try {
    		dipendenteService.save(dipendente);
    	}
    	catch (Exception e) {
    		buildErrorResponse("ERR", "Problemi di salvataggio di un Dipendente sul Database");
    	}
    }
	
	
	@RequestMapping(value= "/addUtenza" , method = RequestMethod.POST)
	public void addUtenza(@RequestBody UserDetailsRequest req) {
		UserDetailsDTO userDto = req.getUserDTO();
		UserDetails user = new UserDetails();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		
		try {
		dipendenteService.addUtenza(user);
		}
		catch (Exception e) {
    		buildErrorResponse("ERR", "Problemi di salvataggio di una utenza sul Database");
    	}
	}
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateDipendente(@RequestBody DipendenteRequest request) {
		DipendenteDTO dto = request.getDto();
    	Dipendente dipendente = new Dipendente();
    	dipendente.setId(dto.getId());
    	dipendente.setNome(dto.getNome());
    	dipendente.setCognome(dto.getCognome());
    	dipendente.setEmail(dto.getEmail());
    	
    	try {
    		dipendenteService.updateDipendente(dipendente);
    	}
    	catch (Exception e) {
    		buildErrorResponse("ERR", "Problemi di salvataggio di un Dipendente sul Database");
    	}
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public void removeDipendente(@RequestBody DipendenteRequest request) {
		DipendenteDTO dto = request.getDto();
    	Dipendente dipendente = new Dipendente();
    	dipendente.setId(dto.getId());
    	dipendente.setNome(dto.getNome());
    	dipendente.setCognome(dto.getCognome());
    	dipendente.setEmail(dto.getEmail());
    	
    	try {
    		dipendenteService.removeDipendente(dipendente);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		buildErrorResponse("ERR", "Problemi di salvataggio di un Dipendente sul Database");
    	}
	}
	
	
	
	  private ErrorResponse buildErrorResponse(String codice, String messaggio) {
	        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
	        errorResponse.setCode(codice);
	        errorResponse.setMessage(messaggio);
	        return errorResponse;
	    }

	    private ResponseEntity<?> buildResponse(Optional<?> optional){
	        if (optional.isPresent()){
	            return new ResponseEntity(optional.get(), HttpStatus.OK);
	        }
	        return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
	    }
}
