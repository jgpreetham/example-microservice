package com.example.userservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

public class UserIdValidator implements ConstraintValidator<UserIdNumeric, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[0-9]+")) {
			return true;
		}
		throw new ValidationException("User Id can't be "+ value +" .The User Id should be numeric.");
	}

}