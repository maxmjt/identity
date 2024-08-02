package com.example.identity.service.exception.common;

/**
 * @author Max.Jimenez
 */
public final class ErrorResponseBuilder {

    public static ErrorResponseBuilder getInstance() {
        return new ErrorResponseBuilder();
    }

    private ErrorResponseBuilder() {

    }

    public <T extends Exception> ErrorResponseContent build(T exception) {
        ExceptionVisitor visitor = new ExceptionVisitor();
        visitor.visit(exception);

        return new ErrorResponseContent(visitor.getType(),
                visitor.getMessage(),
                visitor.getResourceKey(),
                visitor.getAttributes());
    }
}
