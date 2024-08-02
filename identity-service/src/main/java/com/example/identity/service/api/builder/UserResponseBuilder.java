package com.example.identity.service.api.builder;

import com.example.identity.persistence.entity.UserEntity;
import com.example.identity.service.api.response.UserResponse;

/**
 * @author Max.Jimenez
 */
public class UserResponseBuilder {

    private UserResponse instance;

    public static UserResponseBuilder getInstance(UserEntity user) {
        return (new UserResponseBuilder().setUser(user));
    }

    private UserResponseBuilder() {
        instance = new UserResponse();
    }

    private UserResponseBuilder setUser(UserEntity user) {
        instance.setId(user.getId());
        instance.setCreated(user.getCreatedAt());
        instance.setModified(user.getUpdatedAt());
        instance.setLast_login(user.getCreatedAt());
        instance.setToken(user.getToken());
        instance.setIsactive(Boolean.TRUE);

        return this;
    }

    public UserResponse build() {
        return instance;
    }
}
