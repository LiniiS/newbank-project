package com.asantos.newbank.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asantos.newbank.dto.AccountDto;
import com.asantos.newbank.dto.ClientDto;
import com.asantos.newbank.services.AccountService;
import com.asantos.newbank.services.ClientService;

@Controller
@RequestMapping("/admin")
public class AdminResource {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	AccountService accountService;
	
	//Gerenciamento de clientes
	@GetMapping(value="formulario")
	public String showClientForm(ClientDto clientDto) {
		return "/admin/formularioCliente";
	}
	
	
	@PostMapping(value="cliente")
	public String insertNewClient(@Valid ClientDto clientDto, BindingResult result) {
		if(result.hasErrors()) {
			return "/admin/formularioCliente";
		}
		
		clientService.add(clientDto);
		return "redirect:/admin/home";
	}
	

//	@GetMapping(value="clients")
//	public String showAllClients() {
//		return "clientList";
//	}
		
	@GetMapping(value="home")
	public String home(Model model) {
		List<ClientDto> clients = clientService.findAll();
		model.addAttribute("clients", clients);
		return "/admin/index";
	}
	
	
	//gerenciamento de contas
	@GetMapping(value="conta")
	public String showAccountForm(AccountDto AccountDto) {
		return "/admin/formularioConta";
	}
	
	@PostMapping(value="conta")
	public String insertNewAccount(@Valid AccountDto accountDto, BindingResult result) {
		if(result.hasErrors()) {
			return "/admin/formularioConta";
		}
		
		accountService.add(accountDto);
		return "redirect:/admin/home";
	}
	
}
