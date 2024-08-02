package com.example.identity.service.command.user;

import com.example.identity.client.service.UserService;
import com.example.identity.persistence.entity.UserEntity;
import com.example.identity.service.annotations.SynchronousExecution;
import com.example.identity.service.core.BussinessLogicCommad;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Max.Jimenez
 */
@SynchronousExecution
public class UserReadByEmailCmd implements BussinessLogicCommad {

    @Setter
    private String emailInput;

    @Getter
    private UserEntity userEntity;

    private UserService userService;

    public UserReadByEmailCmd(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        saveUser();
    }

    private void saveUser() {
        userEntity = userService.findByEmail(emailInput);
    }
}
