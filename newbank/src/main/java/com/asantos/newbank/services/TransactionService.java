package com.asantos.newbank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asantos.newbank.dto.TransactionDto;
import com.asantos.newbank.entities.Account;
import com.asantos.newbank.entities.Transaction;
import com.asantos.newbank.repositories.AccountRepository;
import com.asantos.newbank.repositories.TransactionRepository;

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

}
