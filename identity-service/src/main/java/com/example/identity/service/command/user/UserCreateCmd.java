package com.example.identity.service.command.user;

import com.example.identity.client.service.UserService;
import com.example.identity.persistence.entity.UserEntity;
import com.example.identity.service.annotations.SynchronousExecution;
import com.example.identity.service.command.jwt.JwtService;
import com.example.identity.service.command.phone.PhoneCreateCmd;
import com.example.identity.service.core.BussinessLogicCommad;
import com.example.identity.service.exception.InvalidEmailException;
import com.example.identity.service.api.input.UserInput;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Max.Jimenez
 */
@SynchronousExecution
public class UserCreateCmd implements BussinessLogicCommad {

    @Setter
    private UserInput input;

    @Getter
    private UserEntity userEntity;

    private UserService userService;

    private JwtService jwtService;

    private PhoneCreateCmd phoneCreateCmd;

    private UserReadByEmailCmd userReadByEmailCmd;

    public UserCreateCmd(UserReadByEmailCmd userReadByEmailCmd,
                         PhoneCreateCmd phoneCreateCmd,
                         UserService userService,
                         JwtService jwtService) {
        this.userReadByEmailCmd = userReadByEmailCmd;
        this.phoneCreateCmd = phoneCreateCmd;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Override
    public void execute() {
        saveUser();
    }

    private void saveUser() {
        validate();

        userEntity = userService.save(composeUserEntityInstance());

        savePhonesByUser();
    }

    private UserEntity composeUserEntityInstance() {
        UserEntity instance = new UserEntity();
        instance.setEmail(input.getEmail());
        instance.setName(input.getName());
        instance.setToken(jwtService.generateToken(input.getEmail()));
        instance.setPassword(input.getPassword());

        return instance;
    }

    private void savePhonesByUser() {
        phoneCreateCmd.setPhoneInputs(input.getPhones());
        phoneCreateCmd.setUserEntity(userEntity);
        phoneCreateCmd.execute();
    }

    private void validate() {
        if (null != getUserEntityByEmail()) {
            throw new InvalidEmailException(input.getEmail());
        }
    }

    private UserEntity getUserEntityByEmail() {
        userReadByEmailCmd.setEmailInput(input.getEmail());
        userReadByEmailCmd.execute();
        return userReadByEmailCmd.getUserEntity();
    }
}
