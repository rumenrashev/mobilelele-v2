package com.spring.mobilelele.service.validations.impl;


import com.spring.mobilelele.service.validations.anotations.ValidName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName,String> {

    private static final String regex = "^[A-Z][A-Za-z]*";

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return name.matches(regex);
    }
}
