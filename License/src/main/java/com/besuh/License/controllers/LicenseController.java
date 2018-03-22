package com.besuh.License.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.besuh.License.models.License;
import com.besuh.License.services.LicenseService;
import com.besuh.License.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
	@Autowired
	private LicenseService ls;
	@Autowired
	private PersonService ps;
	public LicenseController(LicenseService ls) {
		this.ls = ls;
	}
	@RequestMapping("/new")
	public String license(Model model) {
		model.addAttribute("license",new License());
		model.addAttribute("person",ps.noLicense());
		return "license.jsp";
	}
	@PostMapping("/new")
	public String newLicense(@Valid @ModelAttribute("license") License license,BindingResult result, RedirectAttributes red) {
		if(result.hasErrors()){
			red.addFlashAttribute("errors",result.getAllErrors());
			return "redirect:/licenses/new";
		}else{
			ls.create(license);
			return "redirect:/";
		}
	}
}
