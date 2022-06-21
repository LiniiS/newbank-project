package com.asantos.newbank.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.asantos.newbank.entities.Client;

public class ClientDto {

	private Long id;

	// basic personal data
	@NotBlank(message="Nome do cliente é obrigatório.")
	private String firstName;

	@NotBlank(message="Sobrenome do cliente é obrigatório.")
	private String lastName;

	@CPF(message="Número de CPF inválido.")
	private String cpf;

	@NotBlank(message="Número de telefone é obrigatório.")
	private String phone;

	// address data
	@NotBlank(message="Endereço do cliente é obrigatório.")
	private String street;

	@NotBlank(message="Bairro do cliente é obrigatório.")
	private String district;

	@NotBlank(message="Cidade do cliente é obrigatório.")
	private String city;

	@NotBlank(message="Estado do cliente é obrigatório.")
	private String state;

	@NotBlank(message="País do cliente é obrigatório.")
	private String country;

	@NotBlank(message="CEP do cliente é obrigatório.")
	private String zipCode;


	@NotBlank(message="Atribua o número da conta do cliente.")
	private String account;

	public ClientDto() {
	}

	public ClientDto(Long id, String firstName, String lastName, String cpf, String phone, String street,
			String district, String city, String state, String country, String zipCode, String account) {
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
		this.account = account;

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
		this.account = client.getAccount().getAccount();
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


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
