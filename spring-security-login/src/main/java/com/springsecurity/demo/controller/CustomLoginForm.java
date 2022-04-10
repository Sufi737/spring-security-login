package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomLoginForm {
	
	@RequestMapping("/customLoginForm")
	public String showCustomForm() {
		return "login_form";
	}
	
	@RequestMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access_denied";
	}
}
