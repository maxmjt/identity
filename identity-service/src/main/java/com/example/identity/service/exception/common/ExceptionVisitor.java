package com.example.identity.service.exception.common;

import com.example.identity.service.annotations.ErrorResponse;
import com.example.identity.service.annotations.ErrorResponseAttribute;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max.Jimenez
 */
@Getter
class ExceptionVisitor {

    private String message;

    private String resourceKey;

    private String type;

    private Map<String, Object> attributes;

    public ExceptionVisitor() {
        attributes = new HashMap<>();
    }

    private void setType(ErrorResponse annotation, Class<?> exceptionClazz) {
        this.type = annotation.type();

        if (StringUtils.isEmpty(annotation.type())) {
            this.type = exceptionClazz.getSimpleName();
        }
    }

    private void setMessage(ErrorResponse annotation, Class<?> exceptionClazz) {
        this.message = annotation.message();

        if (StringUtils.isEmpty(annotation.message())) {
            this.message = "Throws exception: '" + exceptionClazz.getName() + "'.";
        }
    }

    private void setResourceKey(ErrorResponse annotation, Class<?> exceptionClazz) {
        this.resourceKey = annotation.resourceKey();

        if (StringUtils.isEmpty(annotation.resourceKey())) {
            this.resourceKey = "error." + exceptionClazz.getSimpleName() + "Message";
        }
    }

    private void addAttribute(ErrorResponseAttribute annotation, Field field, Exception exception) {
        ReflectionUtils.makeAccessible(field);

        Object attributeValue = ReflectionUtils.getField(field, exception);
        if (null != attributeValue) {
            String key = field.getName();

            if (!StringUtils.isEmpty(annotation.alias())) {
                key = annotation.alias();
            }

            attributes.put(key, attributeValue);
        }
    }

    public void visit(Exception instance) {
        ErrorResponse errorResponseAnnotation = AnnotationUtils.findAnnotation(instance.getClass(), ErrorResponse.class);

        if (null == errorResponseAnnotation) {
            throw new UnsupportedOperationException("Unhandled exception class "
                    + instance.getClass()
                    + ", the annotation @ErrorResponse is required.");
        }

        setType(errorResponseAnnotation, instance.getClass());
        setMessage(errorResponseAnnotation, instance.getClass());
        setResourceKey(errorResponseAnnotation, instance.getClass());

        ReflectionUtils.doWithFields(
                instance.getClass(),
                (Field field) -> {
                    ErrorResponseAttribute attributeAnnotation = field.getAnnotation(ErrorResponseAttribute.class);

                    addAttribute(attributeAnnotation, field, instance);
                }, field -> field.isAnnotationPresent(ErrorResponseAttribute.class));
    }
}
