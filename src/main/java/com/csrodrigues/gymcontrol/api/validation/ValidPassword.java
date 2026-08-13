package com.csrodrigues.gymcontrol.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy= PasswordValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Password does not meet the security requirements.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

