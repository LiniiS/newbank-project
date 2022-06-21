package com.asantos.newbank.dto;

public class TransactionWithdrawDto  extends TransactionDto{

	public TransactionWithdrawDto(String account, double ammount) {
		super(account, ammount);
		super.setTransactionType("Saque");
	}

		
	
	
}
