package com.besuh.courses.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besuh.courses.models.Course;
import com.besuh.courses.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository cr;
	public CourseService() {}
	public CourseService(CourseRepository cr) {
		this.cr = cr;
	}
	public ArrayList<Course> all() {
		return (ArrayList<Course>) cr.findAll();
	}
	public Course findCourseById(long id) {
		return (Course) cr.findById(id).orElse(null);
	}
	public void create(Course s) {
		cr.save(s);
	}
	public void update(Course s) {
		cr.save(s);
	}
	public void destroy(long id) {
		cr.deleteById(id);
	}
}
