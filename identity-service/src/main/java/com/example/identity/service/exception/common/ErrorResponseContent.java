package com.example.identity.service.exception.common;

import lombok.Getter;

import java.util.Map;

/**
 * @author Max.Jimenez
 */
@Getter
public class ErrorResponseContent {

    private String message;

    private String resourceKey;

    private String type;

    private Map<String, Object> attributes;

    public ErrorResponseContent(String type, String message, String resourceKey, Map<String, Object> attributes) {
        this.type = type;
        this.message = message;
        this.resourceKey = resourceKey;
        this.attributes = attributes;
    }
}
