package com.azienda.test.controller;

import com.azienda.test.AziendaApplication;
import com.azienda.test.service.IDipendenteService;
import com.azienda.test.service.response.ErrorResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController("/azienda")
public class DipendenteContoller {

	private static final Logger logger = LogManager.getLogger(AziendaApplication.class);
	
    @Autowired
    private IDipendenteService aziendaService;

    @GetMapping("/dipendenti")
    public ResponseEntity<?> ricercaTuttiIDipendenti(){
      
    	try{
            logger.info("------------> successfully executed");
            return buildResponse(aziendaService.findAll());
        }catch (Exception e){
            //LOG!
        	logger.error("-----------> Oops! We have an Error. OK");
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
   
    }
    
    
    
/*
    @PostMapping("/ricerca/dipendente")
    public ResponseEntity<?> ricercaDipendente(@RequestBody DipendenteRequest request){
        DipendenteDTO dto = DipendenteDTO.build(request);
        try{
            return buildResponse(aziendaService.ricercaDipendenti(dto));
        }catch (Exception e){
            //LOG!
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
    }

    @GetMapping("/dipendente/{id}")
    public ResponseEntity<?> mostraDipendente(@PathVariable String id){
        Long idDipendente = Long.parseLong(id);
        try{
            return buildResponse(aziendaService.ricercaDipendente(idDipendente));
        }catch (Exception e){
            //LOG!
            return buildErrorResponse("ERR-01", "Errore durante la visualizzazione del dettaglio dipendente: " + e.getMessage());
        }
    }
*/
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
