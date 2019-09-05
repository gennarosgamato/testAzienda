package com.azienda.test.service.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class ErrorResponse extends ResponseEntity {

    private String code;
    private String message;

    public ErrorResponse(HttpStatus status) {
        super(status);
    }
}
