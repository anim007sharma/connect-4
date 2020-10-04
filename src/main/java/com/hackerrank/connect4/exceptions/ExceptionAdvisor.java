package com.hackerrank.connect4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvisor {

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(InvalidCommandException exc){
		CustomErrorResponse error= new CustomErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(InvalidColumnException exc){
		CustomErrorResponse error= new CustomErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exc){
		CustomErrorResponse error= new CustomErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
	