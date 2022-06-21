package com.asantos.newbank.dto;

import javax.validation.constraints.NotNull;

import com.asantos.newbank.entities.Transaction;

public class TransactionDto {

	private Long id;

	@NotNull(message = "Campo 'conta' é obrigatório.")
	private String account;

	private String transactionType;

	@NotNull(message = "Campo 'valor' é obrigatório.")
	private double ammount;

	public TransactionDto(@NotNull(message = "Campo 'conta' é obrigatório.") String account, String transactionType,
			@NotNull(message = "Campo 'valor' é obrigatório.") double amount) {
		this.account = account;
		this.transactionType = transactionType;
		this.ammount = amount;
	}

	public TransactionDto(Transaction transaction) {
		this.id = transaction.getId();
		this.account = transaction.getAccount().getAccount();
		this.transactionType = transaction.getTransactionType();
		this.ammount = transaction.getAmount();

	}

	// construtor pra saque e depósito, só constroi diferente o tipo da transação
	public TransactionDto(String account, double ammount) {
		this.account = account;
		this.ammount = ammount;
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
		return ammount;
	}

	public void setAmount(double amount) {
		this.ammount = amount;
	}

}
