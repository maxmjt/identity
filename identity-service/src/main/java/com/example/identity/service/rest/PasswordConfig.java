package com.example.identity.service.rest;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Component
public class PasswordConfig {

    @Value("${password.pattern}")
    private String passwordPattern;

}
