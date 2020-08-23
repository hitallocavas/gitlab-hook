package br.ufpe.cin.hcs3.opencartapi.v1.entrypoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityAlreadExistsException extends ResponseStatusException {
    private static final String ENTITY_ALREADY_EXISTS_MESSAGE = "%s already exists";

    public <T> EntityAlreadExistsException(T entity){
        super(HttpStatus.BAD_REQUEST, String.format(ENTITY_ALREADY_EXISTS_MESSAGE, entity.getClass().getSimpleName()));
    }
}
