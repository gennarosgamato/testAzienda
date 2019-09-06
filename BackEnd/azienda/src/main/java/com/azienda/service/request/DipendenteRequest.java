package com.azienda.service.request;

import java.io.Serializable;

import com.azienda.service.dto.DipendenteDTO;

/**
 * Request utilizzata per le query di ricerca da FE.
 *
 */
public class DipendenteRequest implements Serializable {

	private DipendenteDTO dto;

	/**
	 * @return the dto
	 */
	public DipendenteDTO getDto() {
		return dto;
	}

	/**
	 * @param dto the dto to set
	 */
	public void setDto(DipendenteDTO dto) {
		this.dto = dto;
	}
	


}
