package com.ty.pgboot_app.pg_app.exception;


public class MustNotBeNullException extends RuntimeException {
	
	private String message = "Field must not be null";
	
	

	public MustNotBeNullException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MustNotBeNullException(String message) {
		super();
		this.message = message;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	
	
	

}
 