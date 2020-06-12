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

import io.awasi.dsmanager.entities.Review;
import io.awasi.dsmanager.entities.Student;
import io.awasi.dsmanager.repositories.ReviewRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.StudentRepository;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/reviews")
	public List<Review> findReviews(){
		return reviewRepository.findAll();
	}
	
	@GetMapping("/review/{id}")
	public Optional<Review> findReview(@PathVariable Integer id){
		return reviewRepository.findById(id);
	}
	
	@GetMapping("/reviews/{id}")
	public List<Review> findReviewsBySchool(@PathVariable Integer id){
		return reviewRepository.findBySchoolId(id);
	}
	
	@PostMapping("/reviews/{id}/{student}")
	public Student addReview(@RequestBody Review review, @PathVariable Integer id, @PathVariable Integer student) {
		review.setSchool(schoolRepository.findById(id).get());
		Student stud = new Student();
		stud = studentRepository.findByStudentPKUsers(student);
		reviewRepository.save(review);
		stud.setReview(review);
		return studentRepository.save(stud);
	}
	
	@PutMapping("/reviews")
	public Review updateCourse(@RequestBody Review review) {
		return reviewRepository.save(review);
	}
	
	@Transactional
	@DeleteMapping("/reviews/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		reviewRepository.deleteById(id);
	}
}
