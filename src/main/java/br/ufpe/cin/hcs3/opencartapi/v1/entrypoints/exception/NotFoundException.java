package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(){
        super(HttpStatus.NOT_FOUND);
    }
}
