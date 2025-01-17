package com.besuh.DojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("name",name);
		session.setAttribute("location",location);
		session.setAttribute("comment",comment);
		return "result.jsp";
	}
}
