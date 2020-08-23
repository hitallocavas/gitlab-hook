package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityAlreadExistsException extends ResponseStatusException {
    private static final String ENTITY_ALREADY_EXISTS_MESSAGE = "this data has already been stored";

    public EntityAlreadExistsException(){
        super(HttpStatus.BAD_REQUEST, ENTITY_ALREADY_EXISTS_MESSAGE);
    }
}
