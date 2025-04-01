package com.example.start.Validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@NotBlank(message = "{required}")
@Size(min = 8, max = 120, message = "{password.length}")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
@Documented
public @interface PasswordConstraint {
    String message() default "{required}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
