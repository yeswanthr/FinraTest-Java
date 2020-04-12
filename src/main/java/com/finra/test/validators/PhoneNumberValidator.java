package com.finra.test.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator  implements ConstraintValidator<PhoneNumber, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = value.toString().length() == 7 || value.toString().length() == 10;
        System.out.println("validation :" + isValid);
        return isValid;
    }
}
