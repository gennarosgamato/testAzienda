package com.azienda.command;

import com.azienda.model.Dipendente;

public interface ICommand {
	
	public void save(Dipendente dipendente);
	
	public void updateDipendente(Dipendente dipendente);
	
	public void removeDipendente(Dipendente dipendente);
}
