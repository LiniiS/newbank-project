package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;

import com.asantos.newbank.entities.Account;

public class AccountDto {
	
	private long id;
	
	
	private long clientId;
	
	@NotBlank(message="Informe o número da conta.")
	private String account;
	
	
	private double balance;
	
	@NotBlank(message="Informe o número do cartão da conta.")
	private String cardNumber;
	
	@NotBlank(message="Defina a senha do cartão.")
	private String password;

	
	public AccountDto() {}
	
	public AccountDto(Account account) {
		this.id = account.getId();
		this.clientId = account.getId();
		this.balance = account.getBalance();
		this.account = account.getAccount();
		this.cardNumber = account.getCardNumber();
		this.password = account.getPassword();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
