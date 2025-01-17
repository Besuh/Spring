package com.besuh.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		return "index.jsp";
	}
	@RequestMapping(path="/code", method=RequestMethod.POST)
	public String code(@RequestParam(value="code") String code, RedirectAttributes red) {
		System.out.println(code);
		if(code.equals("bushido")) {
			return "code.jsp";
		}
		else {
			red.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
	}

}
