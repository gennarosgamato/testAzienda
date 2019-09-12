package com.azienda.command;

import com.azienda.model.Dipendente;
import com.azienda.model.UserDetails;

public interface ICommand {
	
	public void save(Dipendente dipendente);
	
	public void updateDipendente(Dipendente dipendente);
	
	public void removeDipendente(Dipendente dipendente);

	public void addUtenza(UserDetails u);
}
