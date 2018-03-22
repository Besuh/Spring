package com.besuh.DojosNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.DojosNinjas.models.Dojo;
import com.besuh.DojosNinjas.models.Ninja;
import com.besuh.DojosNinjas.services.DojoService;
import com.besuh.DojosNinjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	@Autowired
	private final DojoService ds;
	@Autowired
	private final NinjaService ns;
	public NinjaController(DojoService ds, NinjaService ns) {
		this.ds = ds;
		this.ns=ns;
	}
	@RequestMapping("/new")
	public String newNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", ds.allDojos());
		return "ninja.jsp";
	}
	@PostMapping("/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/ninjas/new";
		}else {
			ns.addNinja(ninja);
			return "redirect:/dojos/"+dojo.getID();
		}
	}
}
