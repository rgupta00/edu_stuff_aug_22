package com.bankapp.exceptions;

public class BankAccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8292185762375491962L;

	public BankAccountNotFoundException(String message) {
		super(message);
	}
}
