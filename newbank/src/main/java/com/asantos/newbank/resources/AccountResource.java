package com.asantos.newbank.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asantos.newbank.dto.AccountDto;
import com.asantos.newbank.services.AccountService;
import com.asantos.newbank.services.ClientService;

@Controller
@RequestMapping("/cliente/conta")
public class AccountResource {

	@SuppressWarnings("unused")
	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;
	
	@GetMapping("saldo")
	public String showBalance(AccountDto accountDto, Model model) {
		//verificar ql é a conta do cliente que está logado
		//é preciso colocar a parte do login
		
		Double currentBalance = accountService.getBalance(accountDto);
		model.addAttribute("currentBalance", currentBalance);				
		
		return "/client/balance";
	}
	
	
}
