package com.bookstore.catalog.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WonStepValidator implements ConstraintValidator<WonStep, Long> {

    private long step;

    @Override
    public void initialize(WonStep constraintAnnotation) {
        this.step = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        return value % step == 0;
    }
}
