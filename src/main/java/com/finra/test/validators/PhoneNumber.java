package com.finra.test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = PhoneNumberValidator.class
)
public @interface PhoneNumber {
    String message() default "phoneNumber length should be either 7 or 10 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
