package com.azienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.azienda.model.Dipendente;
import com.azienda.service.IDipendenteService;
import com.azienda.service.dto.DipendenteDTO;
import com.azienda.service.request.DipendenteRequest;
import com.azienda.service.response.ErrorResponse;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Optional;



@RestController("/azienda")
public class DipendenteContoller {

    @Autowired
    private IDipendenteService dipendenteService;

    
    static final Logger LOGGER = LogManager.getLogger(DipendenteContoller.class.getName());
    
    
    @GetMapping("/dipendenti")
    public ResponseEntity<?> ricercaTuttiIDipendenti(){
    	LOGGER.trace("STO LOGGANDO");
    	LOGGER.info("LOG DI INFO IN GET DIPENDENTI");
    	LOGGER.error("ERROR LOGGER TEST");
        try{
            return buildResponse(dipendenteService.findAll());
        }catch (Exception e){
            //LOG!
        	e.printStackTrace();
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
    }
    
    
    @PostMapping(value = "/saveDipendente")
    public void saveDipendente(@RequestBody DipendenteRequest request) {
    	DipendenteDTO dto = request.getDto();
    	Dipendente dipendente = new Dipendente();
    	dipendente.setNome(dto.getNome());
    	dipendente.setCognome(dto.getCognome());
    	dipendente.setEmail(dto.getEmail());
    	try {
    		dipendenteService.save(dipendente);
    	}catch (Exception e) {
    		buildErrorResponse("ERR", "Problemi di salvataggio di un Dipendente sul Database");
    	}
    	
    }
    
    @PostMapping(value = "/addDip")
    public void addDip(){
    	Dipendente d= new Dipendente();
    	d.setNome("Michele");
    	d.setCognome("Belfiore");
    	d.setAzienda(null);
    	d.setEmail("michele@email.it");
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
