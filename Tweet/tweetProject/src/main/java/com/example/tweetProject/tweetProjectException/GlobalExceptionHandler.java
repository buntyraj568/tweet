package com.example.tweetProject.tweetProjectException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		 ErrorException errorInformation = new ErrorException(new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorInformation, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globleExceptionHandler(Exception ex, WebRequest request) {
	    	ErrorException errorInformation = new ErrorException(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
