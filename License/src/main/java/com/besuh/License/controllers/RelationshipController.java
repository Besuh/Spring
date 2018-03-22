package com.besuh.License.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.License.services.PersonService;

@Controller
@RequestMapping("/")
public class RelationshipController {
	@Autowired
	private PersonService ps;
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("persons", ps.all());
		return "show.jsp";
	}
}
