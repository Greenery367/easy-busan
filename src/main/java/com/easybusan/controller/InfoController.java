package com.easybusan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
	
	@GetMapping("/info")
	public String InfoPage() {
		return "info";
	}
	
}
