package com.example.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorObject> handlePokemonNotFoundException(UserNotFoundException ex, WebRequest request){
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorObject> handleReviewNotFoundException(AccountNotFoundException ex, WebRequest request){
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
	     Map<String, Object> response = new HashMap<>();
	        

	     Map<String, String> errors = new HashMap<>();
	     ex.getBindingResult().getAllErrors().forEach((error) -> {
	         String fieldName = ((FieldError) error).getField();
	         String errorMessage = error.getDefaultMessage();
	         errors.put(fieldName, errorMessage);
	      });
	        

	     response.put("timestamp", new Date());
	     response.put("status", HttpStatus.BAD_REQUEST.value());
	     response.put("errors", errors);

	     return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
