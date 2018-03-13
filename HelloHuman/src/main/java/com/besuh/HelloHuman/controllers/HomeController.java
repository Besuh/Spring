package com.besuh.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, Model model) {
		if (name == null) {
			model.addAttribute("human", "Human");
		}
		else {
			model.addAttribute("human", name);
		}
		return "index.jsp";
	}
}
