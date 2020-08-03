package com.example.userservice.exception;

import javax.validation.ValidationException;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handleUserAlreadyExistsException(Exception e) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(HttpStatus.CONFLICT.toString());
		error.setErrorMessage(e.getMessage());

		ResponseEntity<ErrorDetails> response = new ResponseEntity<ErrorDetails>(error, HttpStatus.CONFLICT);
		return response;

	}
	
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ErrorDetails> handleValidationException(Exception e) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		error.setErrorMessage(e.getCause().getMessage());

		ResponseEntity<ErrorDetails> response = new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
		return response;

	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(Exception e) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(HttpStatus.NOT_FOUND.toString());
		error.setErrorMessage(e.getMessage());

		ResponseEntity<ErrorDetails> response = new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
		return response;

	}

}
