package com.besuh.counter.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("ctr")== null) {
			session.setAttribute("ctr", 0);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		int plus = (int) session.getAttribute("ctr") + 1;
		session.setAttribute("ctr",plus);
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("ctr",0);
		return "redirect:/counter";
	}
}
