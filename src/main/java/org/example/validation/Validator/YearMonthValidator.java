package org.example.validation.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.example.validation.annotation.YearMonth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String patten;
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.patten = constraintAnnotation.patten();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // "2023-01-01T13:00:00" yyyy-mm-ddTHH:mm:ss
        // "20230101"
        // size = 6
        // 아래코드를 구현하는 것이 @NotBlank이다.
        //if(value == null || value.length() != 8){
        //return false;
//      }
        var reValue = value+"01";
        var rePattern = patten+"dd";
        try{
            LocalDate date = LocalDate.parse(reValue , DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
