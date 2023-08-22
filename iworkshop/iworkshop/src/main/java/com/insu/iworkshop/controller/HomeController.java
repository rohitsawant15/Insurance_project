package com.insu.iworkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/* @RequestMapping("/users/") */
public class HomeController {

	@RequestMapping("/hi")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/login")
		public String login() {
			return "login";
		}
	}

