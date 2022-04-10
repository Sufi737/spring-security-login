package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerDemo {
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/leaders")
	public String showLeadersPage() {
		return "leaders_page";
	}
	
	@RequestMapping("/systems")
	public String showSystemsPage() {
		return "systems_page";
	}
}