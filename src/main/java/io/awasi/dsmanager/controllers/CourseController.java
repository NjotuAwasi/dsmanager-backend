package io.awasi.dsmanager.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.Course;
import io.awasi.dsmanager.repositories.CourseRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.UsersRepository;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@GetMapping("/courses")
	public List<Course> findCourses(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/course/{id}")
	public Optional<Course> findCourse(@PathVariable Integer id){
		return courseRepository.findById(id);
	}
	
	@GetMapping("/courses/{id}")
	public List<Course> findCoursesBySchool(@PathVariable Integer id){
		return courseRepository.findBySchoolId(id);
	}
	
	@PostMapping("/courses/{id}/{user}")
	public Course addCourse(@RequestBody Course course, @PathVariable Integer id, @PathVariable Integer user) {
		course.setSchool(schoolRepository.findById(id).get());
		course.setUsers1(usersRepository.findById(id).get());
		return courseRepository.save(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@Transactional
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseRepository.deleteById(id);
	}

}
