package com.spring.mobilelele.service.validations.impl;

import com.spring.mobilelele.service.validations.anotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {

    private static final String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.matches(regex);
    }
}
