package com.azienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.azienda.model.Dipendente;
import com.azienda.service.IDipendenteService;
import com.azienda.service.dto.DipendenteDTO;
import com.azienda.service.request.DipendenteRequest;
import com.azienda.service.response.ErrorResponse;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;



@RestController
public class QueryContoller {

    @Autowired
    private IDipendenteService dipendenteService;
    
    static final Logger LOGGER = LogManager.getLogger(QueryContoller.class.getName());
    
    @GetMapping("/dipendenti")
    public ResponseEntity<?> ricercaTuttiIDipendenti(){
    	LOGGER.trace("STO LOGGANDO");
    	LOGGER.info("LOG DI INFO IN GET DIPENDENTI");
    	LOGGER.error("ERROR LOGGER TEST");
        try{
            return buildResponse(dipendenteService.findAll()); 
        }
        catch (Exception e){
            //LOG!
        	e.printStackTrace();
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
    }    
    
    @GetMapping("/findByPage/{page}")
    public ResponseEntity<?> findCriteria(@PathVariable("page") int pageNumber){
        try{
            return buildResponse(dipendenteService.findAllByPage(pageNumber));
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

    private ResponseEntity<?> buildResponse(Optional<?> optional){
        if (optional.isPresent()){
            return new ResponseEntity(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
    }
   
}
