package com.example.identity.service.command.phone;

import com.example.identity.client.service.PhoneService;
import com.example.identity.persistence.entity.PhoneEntity;
import com.example.identity.persistence.entity.UserEntity;
import com.example.identity.service.annotations.SynchronousExecution;
import com.example.identity.service.core.BussinessLogicCommad;
import com.example.identity.service.api.input.PhoneInput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max.Jimenez
 */
@SynchronousExecution
public class PhoneCreateCmd implements BussinessLogicCommad {

    @Setter
    private UserEntity userEntity;

    @Setter
    private List<PhoneInput> phoneInputs;

    @Getter
    private List<PhoneEntity> phoneEntities;

    private PhoneService phoneService;

    public PhoneCreateCmd(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Override
    public void execute() {
        saveUser();
    }

    private void saveUser() {
        phoneEntities = savePhoneEntities();
    }

    private List<PhoneEntity> savePhoneEntities() {
        List<PhoneEntity> phoneEntities = new ArrayList<>();

        for (PhoneInput phoneInput : phoneInputs) {
            PhoneEntity phoneEntity = phoneService.save(composePhoneEntityInstance(phoneInput));
            phoneEntities.add(phoneEntity);
        }

        return phoneEntities;
    }

    private PhoneEntity composePhoneEntityInstance(PhoneInput phone) {
        PhoneEntity instance = new PhoneEntity();
        instance.setNumber(phone.getNumber());
        instance.setCitycode(phone.getCitycode());
        instance.setContrycode(phone.getContrycode());
        instance.setUser(userEntity);

        return instance;
    }

}
