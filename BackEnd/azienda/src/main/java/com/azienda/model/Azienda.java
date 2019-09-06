package com.azienda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Azienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nomeAzienda;

    @OneToMany(mappedBy = "azienda")
    private List<Dipendente> dipendenti;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nomeAzienda
	 */
	public String getNomeAzienda() {
		return nomeAzienda;
	}

	/**
	 * @param nomeAzienda the nomeAzienda to set
	 */
	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	/**
	 * @return the dipendenti
	 */
	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	/**
	 * @param dipendenti the dipendenti to set
	 */
	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

}
