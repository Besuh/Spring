package com.besuh.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date day = new java.util.Date();
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = sm.format(day);
		model.addAttribute("date", strDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new java.util.Date();
		SimpleDateFormat sm = new SimpleDateFormat("HH:mm");
		String strTime = sm.format(time);
		model.addAttribute("date", strTime);
		return "time.jsp";
	}
}

