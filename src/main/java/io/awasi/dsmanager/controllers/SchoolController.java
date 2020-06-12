package io.awasi.dsmanager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.School;
import io.awasi.dsmanager.repositories.SchoolAdministratorRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.UsersRepository;

@RestController
@RequestMapping("/schools")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SchoolController {
	

	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	SchoolAdministratorRepository schoolAdministratorRepository;
	
	@RequestMapping("/schools")
	public List<School> findAll(){
		List<School> schools = new ArrayList<>();
		schoolRepository.findAll()
		.forEach(schools::add);
		return schools;
	}
	@RequestMapping("/school")
	public Optional<School> findOne(){
		return schoolRepository.findById(1);
	}
	
	@RequestMapping("/school/{id}")
	public Optional<School> getSchool(@PathVariable Integer id){
	return schoolRepository.findById(id);
	}
		
	@PostMapping("school")
	public School addSchool(@RequestBody School school) {
		
		schoolRepository.save(school);
		return school;
		
	}
	

}
