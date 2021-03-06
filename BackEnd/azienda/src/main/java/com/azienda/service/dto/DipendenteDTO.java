package com.azienda.service.dto;

public class DipendenteDTO {

	private int id;
    private String nome;
    private String cognome;
    private String email;

    public static DipendenteDTO build(int id,String nome, String cognome, String email){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setId(id);
        dipendenteDTO.setNome(nome);
        dipendenteDTO.setCognome(cognome);
        dipendenteDTO.setEmail(email);
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
}
