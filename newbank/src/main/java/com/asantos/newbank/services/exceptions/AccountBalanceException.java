package com.asantos.newbank.services.exceptions;

public class AccountBalanceException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public AccountBalanceException(String msg) {
		super(msg);
	}

}