package io.awasi.dsmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.Schoollog;
import io.awasi.dsmanager.repositories.SchoollogRepository;

@RestController
@RequestMapping("/schoollog")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SchoollogController {

	@Autowired
	SchoollogRepository schoollogRepository;
	
	@GetMapping("/schoollog")
	public List<Schoollog> findBranches(){
		return schoollogRepository.findAll();
	}
	
	@GetMapping("/branches/{id}")
	public List<Schoollog> findBranchesBySchool(@PathVariable Integer id){
		return schoollogRepository.findBySchoolId(id);
	}
	
}
