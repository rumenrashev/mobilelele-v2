package com.spring.mobilelele.service.validations.impl;


import com.spring.mobilelele.service.validations.anotations.FieldMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object object, final ConstraintValidatorContext context) {
        Field firstField = getFiledByName(object, firstFieldName);
        Field secondFiled = getFiledByName(object, secondFieldName);
        if (!firstField.equals(secondFiled)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.format(message,firstFieldName))
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private Field getFiledByName(Object object, String fieldName) {
        try {
            return object.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
