package com.spring.mobilelele.service.validations.anotations;

import com.spring.mobilelele.service.validations.impl.PasswordValidator;
import com.spring.mobilelele.service.validations.impl.ValidNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Password should contain upper case letter, " +
            "lower case letter, digit, special symbol and must between 8 and 16 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
