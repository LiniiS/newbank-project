package com.asantos.newbank.services;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asantos.newbank.dto.AccountDto;
import com.asantos.newbank.dto.TransactionDto;
import com.asantos.newbank.dto.TransactionTransferDto;
import com.asantos.newbank.entities.Account;
import com.asantos.newbank.entities.Transaction;
import com.asantos.newbank.repositories.AccountRepository;
import com.asantos.newbank.repositories.TransactionRepository;
import com.asantos.newbank.services.exceptions.AccountBalanceException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	@Transactional
	public TransactionDto deposit(TransactionDto depositDto) {
		Transaction newTransaction = new Transaction();

		getEntityFromDto(depositDto, newTransaction);
		newTransaction.setTransactionType("Depósito");
		newTransaction = transactionRepository.save(newTransaction);

		@SuppressWarnings("deprecation")
		Account account = accountRepository.getById(newTransaction.getAccount().getId());
		account.setBalance(account.getBalance() + newTransaction.getAmount());

		return new TransactionDto(newTransaction);
	}

	private void getEntityFromDto(TransactionDto transactionDto, Transaction newTransaction) {
		newTransaction.setId(transactionDto.getId());
		newTransaction.setAccount(accountRepository.findByAccount(transactionDto.getAccount()));
		newTransaction.setAmount(transactionDto.getAmount());
		newTransaction.setTransactionType(transactionDto.getTransactionType());

	}

	public TransactionDto withdraw(@Valid TransactionDto withdrawDto) {
		Transaction newTransaction = new Transaction();
		
		getEntityFromDto(withdrawDto, newTransaction);
		newTransaction.setTransactionType("Saque");
		newTransaction = transactionRepository.save(newTransaction);
		
		@SuppressWarnings("deprecation")
		Account account = accountRepository.getById(newTransaction.getAccount().getId());
		
		//if balance < amount
		if(!(account.getBalance() > newTransaction.getAmount())) {
			throw new AccountBalanceException("Saldo insuficiente");
		}
		account.setBalance(account.getBalance() - newTransaction.getAmount());
		return new TransactionDto(newTransaction);
	}

	public TransactionTransferDto transfer(TransactionTransferDto transferDto, AccountDto accountDto) {
		
		
		return transferDto;
		
		
	}

}
