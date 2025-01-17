package com.besuh.LearningPlatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
	public String lesson() {
		return "lesson.jsp";
	}
	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
	public String assignment() {
		return "assignment.jsp";
	}

}
