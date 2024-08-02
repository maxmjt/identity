package com.example.identity.service.exception.common;

import com.example.identity.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Max.Jimenez
 */

@ControllerAdvice
public class IdentityServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Resource handlerSocialServiceException(ServiceException exception) {
        return buildErrorResponseValidationService(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Resource methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<Validation> validations = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> new Validation(x.getRejectedValue(), x.getField() + ": " + x.getDefaultMessage()))
                .collect(Collectors.toList());

        return this.buildErrorResponseValidation(validations);
    }

    private Resource buildErrorResponseValidationService(ServiceException exception) {
        ErrorResponseContent errorContent = ErrorResponseBuilder.getInstance().build(exception);
        Resource resource = new Resource();
        resource.setMensaje(errorContent.getResourceKey());
        return resource;
    }

    private Resource buildErrorResponseValidation(List<Validation> validations) {
        String message = validations.stream().map(Validation::getDescription).collect(Collectors.joining(", "));
        Resource resource = new Resource();
        resource.setMensaje(message);
        return resource;
    }
}
