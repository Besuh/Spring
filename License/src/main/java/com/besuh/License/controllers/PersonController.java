package com.besuh.License.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.besuh.License.models.Person;
import com.besuh.License.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	
	private PersonService ps;
	public PersonController(PersonService ps) {
		this.ps = ps;
	}
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		model.addAttribute("person",ps.findByIndex(id));
		return "show.jsp";
	}
	@RequestMapping("/new")
	public String person(Model model) {
		model.addAttribute("person", new Person("asd","asd"));
		return "index.jsp";
	}
	@PostMapping("/new")
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, RedirectAttributes red, Model model) {
		if(result.hasErrors()) {
			red.addFlashAttribute("errors",result.getAllErrors());
			return "redirect:/persons/new";
		}
		else {
			ps.create(person);
			return "redirect:/licenses/new";
		}
	}

}
