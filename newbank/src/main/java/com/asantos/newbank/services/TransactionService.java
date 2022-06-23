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

	@Transactional
	public TransactionDto withdraw(@Valid TransactionDto withdrawDto) {
		Transaction newTransaction = new Transaction();

		getEntityFromDto(withdrawDto, newTransaction);
		newTransaction.setTransactionType("Saque");
		newTransaction = transactionRepository.save(newTransaction);

		@SuppressWarnings("deprecation")
		Account account = accountRepository.getById(newTransaction.getAccount().getId());

		// if balance < amount
		if (!(account.getBalance() > newTransaction.getAmount())) {
			throw new AccountBalanceException("Saldo insuficiente");
		}
		account.setBalance(account.getBalance() - newTransaction.getAmount());
		return new TransactionDto(newTransaction);
	}

	@Transactional
	public TransactionTransferDto transfer(TransactionTransferDto transferDto, AccountDto accountDto) {
		//pegar a conta de quem está logado
		Account originAccount = accountRepository.findByAccount(accountDto.getAccount());
		
		//pegar a conta digitada no form
		Account destinationAccount = accountRepository.findByAccount(transferDto.getDestinationAccount());

		// verificar se o saldo na conta é o suficiente pra transferir	
		// se for suficiente pegar a conta de destino e depositar
		Transaction transferTransaction = new Transaction();
		getEntityFromDto(transferDto, transferTransaction);

		if(originAccount.getBalance() > transferTransaction.getAmount()) {
			originAccount.setBalance(originAccount.getBalance() - transferTransaction.getAmount());
			destinationAccount.setBalance(destinationAccount.getBalance() + transferTransaction.getAmount());
			accountRepository.save(originAccount);
			accountRepository.save(destinationAccount);
		}
		
		
		// retornar a conta de quem está logado
		return new TransactionTransferDto(transferTransaction, originAccount);

	}

	// para transfers
	private void getEntityFromDto(TransactionTransferDto transferDto, Transaction transferTransaction) {
		transferTransaction.setId(transferDto.getId());
		transferTransaction.setAmount(transferDto.getTransferredAmount());
		transferTransaction.setAccount(accountRepository.findByAccount(transferDto.getDestinationAccount()));
		transferTransaction.setTransactionType(transferTransaction.getTransactionType());
		
	}

	// para depósitos
	private void getEntityFromDto(TransactionDto transactionDto, Transaction newTransaction) {
		newTransaction.setId(transactionDto.getId());
		newTransaction.setAccount(accountRepository.findByAccount(transactionDto.getAccount()));
		newTransaction.setAmount(transactionDto.getAmount());
		newTransaction.setTransactionType(transactionDto.getTransactionType());

	}

}
