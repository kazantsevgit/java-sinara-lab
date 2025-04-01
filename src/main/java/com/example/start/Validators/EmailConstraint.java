package com.example.start.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface EmailConstraint {
    String message() default "{email.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String pattern() default "^[A-Za-z0-9]+@[A-Za-z0-9]+\\\\.[A-Za-z]{2,}$";
}
