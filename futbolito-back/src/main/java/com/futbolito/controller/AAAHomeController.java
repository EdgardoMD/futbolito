package com.futbolito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AAAHomeController {
	
	@GetMapping(value = { "/home", "", "/", "/index" })
	public String home() {
		
		
		return "/index";
		}
	

}
