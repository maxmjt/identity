package com.example.identity.service.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
public class UserResponse {

    private UUID id;

    private Date created;

    private Date modified;

    private Date last_login;

    private String token;

    private Boolean isactive;
}
