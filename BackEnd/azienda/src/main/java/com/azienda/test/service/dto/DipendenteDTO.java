package com.azienda.test.service.dto;

import com.azienda.test.service.request.DipendenteRequest;

import lombok.Data;

@Data
public class DipendenteDTO {

    private String nome;
    private String cognome;
    private String email;

    public static DipendenteDTO build(DipendenteRequest request){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setNome(request.getNome());
        dipendenteDTO.setCognome(request.getCognome());
        dipendenteDTO.setEmail(request.getEmail());
        return dipendenteDTO;
    }
}
