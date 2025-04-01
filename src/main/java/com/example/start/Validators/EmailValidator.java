package com.example.start.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private Pattern pattern;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
        pattern = Pattern.compile(constraintAnnotation.pattern());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null || value.isEmpty()) {
            return false;
        }

        if (value.length() < 8 || value.length() > 50) {
            return false;
        }

        if (!value.contains("@") || !value.contains(".")) {
            return false;
        }

        return pattern.matcher(value).matches();
    }
}
