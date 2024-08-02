package com.example.identity.service.annotations;

import java.lang.annotation.*;

/**
 * @author Max.Jimenez
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ErrorResponse {

    String type() default "";

    String message() default "";

    String resourceKey() default "";
}
