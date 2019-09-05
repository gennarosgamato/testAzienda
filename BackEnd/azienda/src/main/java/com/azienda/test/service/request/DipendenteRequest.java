package com.azienda.test.service.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Request utilizzata per le query di ricerca da FE.
 *
 */
@Data
public class DipendenteRequest implements Serializable {

    private String nome;
    private String cognome;
    private String email;
    private String azienda;

}
