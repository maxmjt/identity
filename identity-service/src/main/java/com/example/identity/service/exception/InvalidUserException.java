package com.example.identity.service.exception;

import com.example.identity.service.annotations.ErrorResponse;
import com.example.identity.service.annotations.ErrorResponseAttribute;

/**
 * @author Max.Jimenez
 */
@ErrorResponse(resourceKey = InvalidUserException.KEY)
public class InvalidUserException extends ServiceException {

    public static final String KEY = "INVALID_USER";

    @ErrorResponseAttribute
    private final String userId;

    public InvalidUserException(String userId) {
        this.userId = userId;
    }
}
