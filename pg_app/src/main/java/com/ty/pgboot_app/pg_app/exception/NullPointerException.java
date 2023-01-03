package com.ty.pgboot_app.pg_app.exception;

public class NullPointerException extends RuntimeException {
		private String message = "Field must not be null";
	
	

	public NullPointerException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public NullPointerException(String message) {
		super();
		this.message = message;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
