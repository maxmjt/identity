package com.example.identity.service.exception;

import com.example.identity.service.annotations.ErrorResponse;
import com.example.identity.service.annotations.ErrorResponseAttribute;

/**
 * @author Max.Jimenez
 */
@ErrorResponse(resourceKey = InvalidEmailException.KEY)
public class InvalidEmailException extends ServiceException {

    public static final String KEY = "INVALID_EMAIL";

    @ErrorResponseAttribute
    private final String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }
}
