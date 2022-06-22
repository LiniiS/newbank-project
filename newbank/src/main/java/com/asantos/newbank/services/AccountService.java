package com.asantos.newbank.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asantos.newbank.dto.AccountDto;
import com.asantos.newbank.dto.TransactionDto;
import com.asantos.newbank.entities.Account;
import com.asantos.newbank.repositories.AccountRepository;
import com.asantos.newbank.services.exceptions.AccountDoesNotExistException;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Transactional(readOnly = true)
	public List<AccountDto> findAll() {
		List<Account> accountList = accountRepository.findAll();
		return accountList.stream().map(account -> new AccountDto(account)).collect(Collectors.toList());
	}

	@Transactional
	public AccountDto add(AccountDto accountDto) {
		Account newAccount = new Account();
		getEntityFromDto(accountDto, newAccount);
		newAccount = accountRepository.save(newAccount);
		return new AccountDto(newAccount);

	}

	private void getEntityFromDto(AccountDto accountDto, Account newAccount) {
		newAccount.setAccount(accountDto.getAccount());
		newAccount.setBalance(accountDto.getBalance());
		newAccount.setCardNumber(accountDto.getCardNumber());
		newAccount.setPassword(accountDto.getPassword());

	}

	public boolean checkAccount(@Valid TransactionDto transactionDepositDto) {

		Optional<Account> optionalAccount = Optional
				.of(accountRepository.findByAccount(transactionDepositDto.getAccount()));
		if (!optionalAccount.isPresent()) {
			throw new AccountDoesNotExistException("Conta informada não existe: " + optionalAccount);
		}
		return true;
	}

}