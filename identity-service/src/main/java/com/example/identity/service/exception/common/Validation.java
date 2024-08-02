package com.example.identity.service.exception.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Max.Jimenez
 */
@Getter
@Setter
public class Validation {

    private Object invalidValue;

    private String description;

    public Validation(Object invalidValue, String description) {
        this.invalidValue = invalidValue;
        this.description = description;
    }
}
