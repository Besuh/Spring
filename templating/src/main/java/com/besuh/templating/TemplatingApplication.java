package com.besuh.templating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class TemplatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplatingApplication.class, args);
	}
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
        return "index.jsp";
    }
}
}
