package com.besuh.Crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.besuh.Crud.services.LanguageService;
import com.besuh.Crud.models.Language;

@Controller
@RequestMapping("/languages")
public class HomeController {
	@Autowired
	private final LanguageService languageService;
	public HomeController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		model.addAttribute("language", new Language());
		return "index.jsp";

	}
	@RequestMapping("/{id}")
	public String findLanguageByIndex(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "language.jsp";
	}
	@RequestMapping("/add")
	public String add(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages/"+language.getID();
		}
		else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Language language = languageService.findLanguageById(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}else {
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Integer id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		System.out.println(id + "wow");
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}
}
