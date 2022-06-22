package com.asantos.newbank.services.exceptions;

public class AccountDoesNotExistException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;
	
	public AccountDoesNotExistException(String msg) {
		super(msg);
	}

}
