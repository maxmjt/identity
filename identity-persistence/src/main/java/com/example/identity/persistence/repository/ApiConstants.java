package com.example.identity.persistence.repository;

/**
 * @author Max.Jimenez
 */
public final class ApiConstants {

    private static final String ACTION = "Utility class";

    private ApiConstants() {
        throw new IllegalStateException(ACTION);
    }

    public static class CustomPassword {

        private CustomPassword() {
            throw new IllegalStateException(ACTION);
        }

        public static final String REGEX = "${custom.password.regex}";
    }
}
