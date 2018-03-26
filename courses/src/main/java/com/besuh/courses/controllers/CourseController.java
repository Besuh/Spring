package com.besuh.courses.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.courses.models.Course;
import com.besuh.courses.models.User;
import com.besuh.courses.services.CourseService;
import com.besuh.courses.services.UserService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	public UserService us;
	public CourseService cs;
	public CourseController(UserService us, CourseService cs) {
		this.us = us;
		this.cs = cs;
	}
	@RequestMapping("/new")
	public String newCourse(@ModelAttribute("course") Course course, Model model) {
		model.addAttribute("courses", cs.all());
		return "newCourse.jsp";
	}
	@PostMapping("/new")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/courses/new";
		}else {
			cs.create(course);
			return "redirect:/courses/"+course.getId();
		}
	}
	@RequestMapping("/{id}")
	public String showCourse(@PathVariable("id") long id, Model model) {
		Course s = cs.findCourseById(id);
		model.addAttribute("course",cs.findCourseById(id));
		if (s!= null) {
			System.out.println(s + "wow");
			model.addAttribute("x", s);
			return "show.jsp";
		}
		else {
			return "redirect:/courses/new";
		}
	}
	@RequestMapping("/{id}/edit")
	public String editCourse(@PathVariable("id") long id, Model model) {
		Course s = cs.findCourseById(id);
		model.addAttribute("course",cs.findCourseById(id));
		if (s!= null) {
			System.out.println(s + "wow");
			model.addAttribute("x", s);
			return "edit.jsp";
		}
		else {
			return "redirect:/courses";
		}
	}
	@PostMapping("/{id}/edit")
	public String edit(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/courses/"+course.getId()+"/edit";
		}else {
			cs.create(course);
			return "redirect:/";
		}
	}
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") long id) {
		cs.destroy(id);
		return "redirect:/";
	}
	@RequestMapping("/{id}/join")
	public String join(Principal principal, @PathVariable("id") Long id, Model model) {
		Course c = cs.findCourseById(id);
		String username = principal.getName();
		User user = us.findByUsername(username);
		System.out.println(user.getFirstName());
		List<User> list = c.getUsers();
		list.add(user);
		System.out.println(list);
		c.setUsers(list);
		cs.update(c);
		System.out.println(c.getUsers());
		return "redirect:/";
	}
}
