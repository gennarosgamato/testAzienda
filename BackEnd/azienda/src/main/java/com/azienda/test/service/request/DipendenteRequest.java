package com.azienda.test.service.request;

import java.io.Serializable;

/**
 * Request utilizzata per le query di ricerca da FE.
 *
 */
public class DipendenteRequest implements Serializable {

    private String nome;
    private String cognome;
    private String email;
    private String azienda;
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
	/**
	 * @return the azienda
	 */
	public String getAzienda() {
		return azienda;
	}
	/**
	 * @param azienda the azienda to set
	 */
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

}
