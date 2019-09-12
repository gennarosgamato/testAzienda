package com.azienda.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;


@Entity
public class UserDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	@OneToOne
	private Dipendente dipendente;
	
	
	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public UserDetails(int id, String username, String password, Dipendente dipendente) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.dipendente=dipendente;
	}
	/**
	 * 
	 */
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
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
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dipendente
	 */
	public Dipendente getDipendente() {
		return dipendente;
	}
	/**
	 * @param dipendente the dipendente to set
	 */
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	
	
	
}
