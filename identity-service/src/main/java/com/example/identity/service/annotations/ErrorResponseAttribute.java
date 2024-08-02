package com.example.identity.service.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ErrorResponseAttribute {

    String alias() default "";
}
