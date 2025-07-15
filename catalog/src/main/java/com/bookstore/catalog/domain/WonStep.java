package com.bookstore.catalog.domain;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WonStepValidator.class)
@Documented
public @interface WonStep {
    String message() default "가격은 {value}원 단위로 입력해야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    long value() default 10;
}
