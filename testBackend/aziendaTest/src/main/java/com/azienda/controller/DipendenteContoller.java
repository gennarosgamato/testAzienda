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
    
    @RequestMapping(value = "/saveDipendente", method = RequestMethod.POST)
    public void saveDipendente(@RequestBody DipendenteRequest request) {
    	DipendenteDTO dto = DipendenteDTO.build(request);
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