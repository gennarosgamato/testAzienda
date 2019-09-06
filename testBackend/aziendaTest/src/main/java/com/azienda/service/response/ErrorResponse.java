package com.azienda.service.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ErrorResponse extends ResponseEntity {

    private String code;
    private String message;

    public ErrorResponse(HttpStatus status) {
        super(status);
    }

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
    
}
