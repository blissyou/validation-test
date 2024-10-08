package org.example.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.validation.Validator.YearMonthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {
    String message() default "날짜 형식에 맞지 않습니다.";

    String patten() default "yyyyMMdd";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
