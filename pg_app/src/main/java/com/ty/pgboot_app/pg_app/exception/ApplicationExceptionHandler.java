package com.ty.pgboot_app.pg_app.exception;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.pgboot_app.pg_app.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundException(NoSuchIdFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No id found");
		responseStructure.setData(exception.getMesssage());
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseEntity<ResponseStructure<String>> unableToUpdateException(UnableToUpdateException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No id found");
		responseStructure.setData(exception.getMessage());
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(UnableToDeleteException.class)
	public ResponseEntity<ResponseStructure<String>> unableToDeleteException(UnableToDeleteException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No id found");
		responseStructure.setData(exception.getMessage());
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();

		for (ObjectError er : errors) {

			String message = er.getDefaultMessage();
			String fieldName = ((FieldError) er).getField();
			map.put(fieldName, message);

			ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String, String>>();
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("no proper input");
			responseStructure.setData(map);
			return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
		}
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

}
