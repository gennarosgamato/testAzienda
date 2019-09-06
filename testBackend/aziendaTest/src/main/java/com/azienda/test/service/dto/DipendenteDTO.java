package com.azienda.test.service.dto;

import com.azienda.test.service.request.DipendenteRequest;

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

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
    
}
