package com.trainingapps.forex.transactionms.exceptions;

public class TransactionIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionIdNotFoundException(String message) {
		super(message);
	}
}
