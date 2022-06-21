package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.asantos.newbank.entities.Client;

public class ClientDto {

	private Long id;

	// basic personal data
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@CPF
	private String cpf;

	@NotBlank
	private String phone;

	// address data
	@NotBlank
	private String street;

	@NotBlank
	private String district;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String country;

	@NotBlank
	private String zipCode;

	// card data
	@NotNull
	private long card;

	@NotBlank
	private String password;

	@NotNull
	private Long accountId;

	public ClientDto() {
	}

	public ClientDto(Long id, String firstName, String lastName, String cpf, String phone, String street,
			String district, String city, String state, String country, String zipCode, long card, String password, Long accountId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.phone = phone;
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.card = card;
		this.password = password;
		this.accountId = accountId;

	}

	public ClientDto(Client client) {
		this.id = client.getId();
		this.firstName = client.getFirstName();
		this.lastName = client.getLastName();
		this.cpf = client.getCpf();
		this.phone = client.getPhone();
		this.street = client.getStreet();
		this.district = client.getDistrict();
		this.city = client.getCity();
		this.state = client.getState();
		this.country = client.getCountry();
		this.zipCode = client.getZipCode();
		this.card = client.getCard();
		this.password = client.getPassword();
		this.accountId = client.getAccount().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getCard() {
		return card;
	}

	public void setCard(long card) {
		this.card = card;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
