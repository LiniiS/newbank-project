package com.asantos.newbank.dto;

public class TransactionDepositDto extends TransactionDto {

	public TransactionDepositDto(String destinationAccount, double ammount) {
		super(destinationAccount, ammount);
		super.setTransactionType("Depósito");
	}

}
