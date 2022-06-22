package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.asantos.newbank.entities.Transaction;

public class TransactionDepositDto {

	private Long id;

	@NotNull(message = "É obigatório informar a quantia a ser depositada.")
	private double amount;

	private String originAccount;

	@NotBlank(message = "Conta favorecida é obrigatória.")
	private String destinationAccount;

	private String transactionType;

	public TransactionDepositDto(@NotNull(message = "É obigatório informar a quantia a ser depositada.") double amount,
			@NotBlank(message = "Conta favorecida é obrigatória.") String destinationAccount) {
		this.amount = amount;
		this.destinationAccount = destinationAccount;
		this.setTransactionType("Depósito");
	}

	public TransactionDepositDto(Transaction transaction) {
		this.id = transaction.getId();
		this.amount = transaction.getAmount();
		this.destinationAccount = transaction.getAccount().getAccount();
		this.transactionType = transaction.getTransactionType();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(String originAccount) {
		this.originAccount = originAccount;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
