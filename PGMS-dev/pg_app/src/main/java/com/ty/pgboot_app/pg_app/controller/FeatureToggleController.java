package com.ty.pgboot_app.pg_app.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class FeatureToggleController {
	 @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
}
}