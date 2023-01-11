package com.ty.pgboot_app.pg_app.exception;


public class MustNotBeBlankException extends RuntimeException {
	
	private String message = "Field must not be blank";
	
	

	public MustNotBeBlankException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MustNotBeBlankException(String message) {
		super();
		this.message = message;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	
	
	

}
 