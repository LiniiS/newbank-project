package com.asantos.newbank.entities;

public class Login {
	
	
	private Long id;
	
	private String secretCode;
	private String password;
	
	
	Client client;
	
	public Login() {}
	
	public Login(String secretCode, String password) {
		this.secretCode = secretCode;
		this.password = password;
	}

	public String getSecretCode() {
		return secretCode;
	}

	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
