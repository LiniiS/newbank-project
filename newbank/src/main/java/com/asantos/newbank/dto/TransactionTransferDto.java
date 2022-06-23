package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.asantos.newbank.entities.Account;
import com.asantos.newbank.entities.Transaction;

public class TransactionTransferDto {

	private Long id;

	@NotBlank
	private String originAccount;

	@NotBlank(message = "Campo de conta de destino inválido.")
	private String destinationAccount;

	@NotNull(message = "O campo da quantia a ser transferia é obrigatório.")
	@Positive(message = "Quantia a ser transferida inválida.")
	private double transferredAmount;

	public TransactionTransferDto() {
	}

	public TransactionTransferDto(Long id, @NotBlank String originAccount,
			@NotBlank(message = "Campo de conta de destino inválido.") String destinationAccount,
			@NotNull(message = "O campo da quantia a ser transferia é obrigatório.") @Positive(message = "Quantia a ser transferida inválida.") double transferredAmount) {
		this.id = id;
		this.originAccount = originAccount;
		this.destinationAccount = destinationAccount;
		this.transferredAmount = transferredAmount;
	}

	public TransactionTransferDto(Transaction transaction, Account account) {
		this.id = transaction.getId();
		this.destinationAccount = transaction.getAccount().getAccount();
		this.transferredAmount = transaction.getAmount();
		this.destinationAccount = account.getAccount();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

}
