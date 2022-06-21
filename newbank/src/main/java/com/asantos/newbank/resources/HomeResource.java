package com.asantos.newbank.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeResource {
	
	@GetMapping
	public String showHomePage() {
		return "index";
	}

	@GetMapping(value="admin")
	public String showAdminLoginPage() {
		return "/admin/admin";
	}

	

	@GetMapping(value="cliente")
	public String showClientHomePage(Model model) {
		return "cliente";
	}
}