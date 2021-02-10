package com.spring.mobilelele.service.validations.impl;

import com.spring.mobilelele.data.repositories.UserRepository;
import com.spring.mobilelele.service.validations.anotations.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return this.userRepository.findByEmail(email).isEmpty();
    }
}
