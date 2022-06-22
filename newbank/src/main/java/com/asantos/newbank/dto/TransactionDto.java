package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.asantos.newbank.entities.Transaction;

public class TransactionDto {

	private Long id;

	@NotBlank(message = "Campo 'conta favorecida' é obrigatório.")
	private String account;

	private String transactionType;

	@NotNull(message = "Campo 'valor' é obrigatório.")
	private double amount;

	public TransactionDto() {}
	
	public TransactionDto(@NotBlank(message = "Campo 'conta' é obrigatório.") String account, String transactionType,
			@NotNull(message = "Campo 'valor' é obrigatório.") double amount) {
		this.account = account;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public TransactionDto(Transaction transaction) {
		this.id = transaction.getId();
		this.account = transaction.getAccount().getAccount();
		this.transactionType = transaction.getTransactionType();
		this.amount = transaction.getAmount();

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
