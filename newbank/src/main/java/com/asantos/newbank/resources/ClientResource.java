package com.asantos.newbank.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/cliente")
public class ClientResource {

	@GetMapping(value="/")
	public String showClientHomePage() {
		return "cliente";
	}
}
