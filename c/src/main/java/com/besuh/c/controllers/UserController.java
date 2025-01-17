package com.besuh.c.controllers;

@Controller
@RequestMapping("/users")
public class UserController {
	private UserService us;
	
	public UserController(UserService us) {
		this.us=us;
	}
	//Dashboard
	@RequestMapping("")
	public String dashboard(Model model, HttpSession session) {
		if(!us.isValid(session)) {
			return us.redirect();
		}
		model.addAttribute("users", this.us.all());
		return "dashboard";
	}
	//Logout on visiting login/registration
	@RequestMapping("/new")
	public String newUser(@ModelAttribute("user") User user, HttpSession session)
	{
		us.logout(session);
		return "newuser";
	}
	//Create a user
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult res,
						RedirectAttributes flash,
						HttpSession session) {
		if(res.hasErrors()) {
			flash.addFlashAttribute("errors",res.getAllErrors());
			return "redirect:/users/new";
		}
		else {
			User exists = us.findByEmail(user.getEmail());
			
			if(exists == null) {
				User u = us.create(user);
				us.login(session,  u.getId());
				return "redirect:/users";
			}
			else {
				flash.addFlashAttribute("error","A user with this email already exists.");
				return "redirect:/users/new";
			}
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("password") String password,
						HttpSession session,
						RedirectAttributes flash) {
		if(email.length() < 1) {									//Don't waste a query
			flash.addFlashAttribute("error","Email cannot be blank.");
			return "redirect:/users/new";
		}
		
		User user = us.findByEmail(email);
		
		if(user == null) {
			flash.addFlashAttribute("error","No user with this email was found.");
			return "redirect:/users/new";
		}
		else {
			if(us.isMatch(password, user.getPassword())) {
				us.login(session, user.getId());
				if(user.isHost()) {
					return "redirect:/listings/host";
				}
				return "redirect:/listings";
			}
			else {
				flash.addFlashAttribute("error","Invalid Credentials");
				return "redirect:/users/new";
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession s) {
		return us.redirect();
	}
}