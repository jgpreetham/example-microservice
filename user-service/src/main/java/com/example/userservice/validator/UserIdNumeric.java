package com.example.userservice.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = UserIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdNumeric {
	String message() default "The User Id can be numeric.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}