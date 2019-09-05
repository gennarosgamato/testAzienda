package com.azienda.test.controller;

import com.azienda.test.service.IAziendaService;
import com.azienda.test.service.dto.DipendenteDTO;
import com.azienda.test.service.request.DipendenteRequest;
import com.azienda.test.service.response.ErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController("/azienda")
public class AziendaContoller {

    @Autowired
    private IAziendaService aziendaService;

    @GetMapping("/dipendenti")
    public ResponseEntity<?> ricercaDipendente(){
        try{
            return buildResponse(aziendaService.ricercaDipendenti());
        }catch (Exception e){
            //LOG!
            return buildErrorResponse("ERR-02", "Errore durante la visualizzazione della lista dei dipendenti: " + e.getMessage());
        }
    }

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
