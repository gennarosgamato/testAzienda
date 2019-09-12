package com.azienda.service.request;

import com.azienda.service.dto.UserDetailsDTO;

public class UserDetailsRequest {

	private UserDetailsDTO userDTO;

	/**
	 * @return the userDTO
	 */
	public UserDetailsDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * @param userDTO the userDTO to set
	 */
	public void setUserDTO(UserDetailsDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
