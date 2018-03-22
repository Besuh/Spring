package com.besuh.DojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.DojosNinjas.models.Dojo;
import com.besuh.DojosNinjas.services.DojoService;
import com.besuh.DojosNinjas.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private final DojoService ds;
	@Autowired
	private final NinjaService ns;
	public DojoController(DojoService ds, NinjaService ns) {
		this.ds = ds;
		this.ns=ns;
	}
	@RequestMapping("/new")
	public String newDojo(Model model) {
		model.addAttribute("dojos", ds.allDojos());
		model.addAttribute("dojo", new Dojo());
		return "dojo.jsp";
	}
	@PostMapping("/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/dojos/new";
		}else {
			ds.addDojo(dojo);
			return "redirect:/dojos/"+dojo.getID();
		}
	}
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Dojo dojo = ds.findDojoById(id);
		model.addAttribute("ninjas",ns.findNinjasByDojo(id));
		if (dojo!= null) {
			System.out.println(dojo + "wow");
			model.addAttribute("x", dojo);
			return "show.jsp";
		}
		else {
			return "redirect:/dojos/new";
		}
		
	}
}
