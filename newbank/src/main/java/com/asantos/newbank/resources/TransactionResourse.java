package com.asantos.newbank.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionResourse {
	
	@GetMapping
	public String showHomePage() {
		return "/transaction/index";
	}
	
	
	//requisição pra depositar (não precisa estar logado)
		//faz um post com a conta de origem, conta de destino e o valor -> como nao está logado solicitar a conta de origem
	
	
	
	
	//requsicao pra ver as transacoes (precisa ser cliente logado pra ver)
	
	
		
	
	//requisicao pra sacar (precisa ser cliente logado pra sacar)
	
	
	
}
