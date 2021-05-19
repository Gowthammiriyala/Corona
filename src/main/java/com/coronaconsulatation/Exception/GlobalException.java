package com.coronaconsulatation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException i) {
		return new ResponseEntity<String>(i.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PatientException.class)
	public ResponseEntity<String> handlePatientException(PatientException p) {
		return new ResponseEntity<String>(p.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ServiceException.class)
	public ResponseEntity<String> handleServiceException(ServiceException s) {
		return new ResponseEntity<String>(s.getMessage(), HttpStatus.NOT_FOUND);
	}

}
