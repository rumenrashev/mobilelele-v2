package com.spring.mobilelele.service.validations.anotations;

import com.spring.mobilelele.service.validations.impl.ValidNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {


    String message() default "Should start with capital letter and must contain only letters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
