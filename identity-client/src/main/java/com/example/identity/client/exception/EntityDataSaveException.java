package com.example.identity.client.exception;

/**
 * @author Max.Jimenez
 */
public class EntityDataSaveException extends RuntimeException {

    public EntityDataSaveException(Object entity) {
        super("Unable to save entity" + entity.getClass().getName());
    }
}
