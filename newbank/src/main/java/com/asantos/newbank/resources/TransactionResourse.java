package com.asantos.newbank.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asantos.newbank.dto.TransactionDto;
import com.asantos.newbank.services.AccountService;
import com.asantos.newbank.services.TransactionService;

@Controller
@RequestMapping("/transacao")
public class TransactionResourse {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private AccountService accountService;

	@GetMapping
	public String showHomePage() {
		return "/transaction/index";
	}

	// requisição pra depositar (não precisa estar logado)
	// faz um post com a conta de origem, conta de destino e o valor -> como nao
	// está logado solicitar a conta de origem

	// Gerenciamento de depósitos
	@GetMapping(value = "deposito")
	public String showDepositForm(TransactionDto transactionDepositDto) {
		return "/transaction/formularioDeposito";
	}

	@PostMapping(value = "deposito")
	public String insertNewDeposit(@Valid TransactionDto transactionDepositDto, BindingResult result) {
		if (result.hasErrors()) {
			return "/transaction/formularioDeposito";
		}
				
		//TODO verificar se a conta digitada existe e interceptar o erro		

		transactionService.deposit(transactionDepositDto);

		return "redirect:/transacao";
	}

	// requsicao pra ver as transacoes (precisa ser cliente logado pra ver)

	// requisicao pra sacar (precisa ser cliente logado pra sacar)

}
