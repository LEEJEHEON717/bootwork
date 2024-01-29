package com.khit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {
	
	@GetMapping("/public-data/main")
	public String dataMain() {
		return "/public-data/main"; //public-data/main
	}
	
	@GetMapping("/disaster.do")
	public String getData() {
		return null;
	}
}
