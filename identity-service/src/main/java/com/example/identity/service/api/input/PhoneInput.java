package com.example.identity.service.api.input;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class PhoneInput {

    @NonNull
    private Integer number;

    private Integer citycode;

    private Integer contrycode;
}
