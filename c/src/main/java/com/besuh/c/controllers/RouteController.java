package com.besuh.c.controllers;

@Controller
@RequestMapping("/**")  //Wildcard all routes.
public class RouteController {
	private UserService us;
	
	public RouteController(UserService us) {
		this.us=us;
	}
	//If route doesnt exists, redirect to login if not in session, else dashboard.
	@RequestMapping("")
	public String index(HttpServletRequest req, HttpSession s) {
		if(!us.isValid(s)) {
			return "redirect:/users/new";
		}
		else {
			User user = us.find((Long)s.getAttribute("id"));
			
			if(user.isHost()) {
				return "redirect:/listings/host";
			}
			else {
				return "redirect:/listings";
			}
		}
	}
}