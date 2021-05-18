package com.coronaconsulatation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value =  Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value =  PatientException.class)
	public ResponseEntity<String> handlePatientException(PatientException p) {
		return new ResponseEntity<String>(p.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value =  IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException i) {
		return new ResponseEntity<String>(i.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
