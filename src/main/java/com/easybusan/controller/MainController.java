package com.easybusan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	
	@RequestMapping("/main")
	public String list() {
		log.info("@# MainController list");
		
		return "main";
	}
}

