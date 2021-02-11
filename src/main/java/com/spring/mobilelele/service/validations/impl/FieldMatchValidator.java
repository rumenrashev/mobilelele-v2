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

        Object firstField , secondField;
        try {
            firstField = getFiledByName(object, firstFieldName);
            secondField = getFiledByName(object, secondFieldName);
        }catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
            return false;
        }
        if (!firstField.equals(secondField)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.format(message,firstFieldName))
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private Object getFiledByName(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {

            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
    }
}
