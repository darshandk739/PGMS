package com.ty.pgboot_app.pg_app.exception;

import javax.print.DocFlavor.READER;

public class NoSuchIdFoundException extends RuntimeException{
	private String message ="No such id found in database";

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		super();
	}

	public String getMesssage() {
		return message;
	}


}
