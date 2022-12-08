package com.ty.pgboot_app.pg_app.exception;

public class UnableToDeleteException extends RuntimeException {
	private String message= "No such id found in database";

	public UnableToDeleteException(String message) {
		super();
		this.message = message;
	}

	public UnableToDeleteException() {
		super();
	}

	public String getMessage() {
		return message;
	}

}
