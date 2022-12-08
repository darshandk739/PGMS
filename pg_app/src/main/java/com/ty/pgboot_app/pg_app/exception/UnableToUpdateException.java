package com.ty.pgboot_app.pg_app.exception;

public class UnableToUpdateException extends RuntimeException{ 

	private String message = "No such id found in database";

	public UnableToUpdateException(String message) {
		super();
		this.message = message;
	}

	public UnableToUpdateException() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
}
