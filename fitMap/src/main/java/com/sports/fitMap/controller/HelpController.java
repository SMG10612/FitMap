package com.sports.fitMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpController {
	
	@GetMapping("/help")
	public String index() {
		return "help";
	}
}
