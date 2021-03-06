package com.asantos.newbank.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.newbank.dto.ClientDto;
import com.asantos.newbank.entities.Client;
import com.asantos.newbank.repositories.AccountRepository;
import com.asantos.newbank.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Transactional(readOnly=true)
	public List<ClientDto> findAll(){
		List<Client> clientList = clientRepository.findAll();
		return clientList.stream().map(client -> new ClientDto(client)).collect(Collectors.toList());
	}

	@Transactional
	public ClientDto add(ClientDto clientDto) {
		Client newClient = new Client();
		getEntityFromDto(clientDto, newClient);
		
		//Account clientAccount = accountRepository.findByAccount(clientDto.getAccount());
		//antes de setar, buscar no DB o número da conta do cliente
		
		
		newClient = clientRepository.save(newClient);
		
		return new ClientDto(newClient);
		
	}

	
	private void getEntityFromDto(ClientDto clientDto, Client newClient) {
		newClient.setFirstName(clientDto.getFirstName());
		newClient.setLastName(clientDto.getLastName());
		newClient.setCpf(clientDto.getCpf());
		newClient.setStreet(clientDto.getStreet());
		newClient.setDistrict(clientDto.getDistrict());
		newClient.setCity(clientDto.getDistrict());
		newClient.setState(clientDto.getState());
		newClient.setCountry(clientDto.getCountry());
		newClient.setZipCode(clientDto.getZipCode());
		newClient.setPhone(clientDto.getPhone());
		newClient.setAccount(accountRepository.findByAccount(clientDto.getAccount()));
		
	}

}
