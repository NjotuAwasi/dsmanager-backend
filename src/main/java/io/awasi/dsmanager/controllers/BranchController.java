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

import io.awasi.dsmanager.entities.Branch;
import io.awasi.dsmanager.entities.School;
import io.awasi.dsmanager.repositories.BranchRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;

@RestController
@RequestMapping("/branches")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BranchController {
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@GetMapping("/branches")
	public List<Branch> findBranches(){
		return branchRepository.findAll();
	}
	
	@GetMapping("/count/{id}")
	public Integer countBranch(@PathVariable Integer id){
		return branchRepository.countBySchoolId(id);
	}
	
	@GetMapping("/branch/{id}")
	public Optional<Branch> findBranch(@PathVariable Integer id){
		return branchRepository.findById(id);
	}
	
	@GetMapping("/branches/{id}")
	public List<Branch> findBranchesBySchool(@PathVariable Integer id){
		return branchRepository.findBySchoolId(id);
	}
	
	@PostMapping("/branches/{id}")
	public Branch addBranch(@RequestBody Branch branch, @PathVariable Integer id) {
		branch.setSchool(schoolRepository.findById(id).get());
		return branchRepository.save(branch);
	}
	
	@PutMapping("/branches/{id}")
	public Branch updateBranch(@RequestBody Branch branch,  @PathVariable Integer id) {
		School school = new School();
		school = schoolRepository.findById(id).get();
		branch.setSchool(school);
		System.out.print(school);
		return branchRepository.save(branch);
	}
	
	@Transactional
	@DeleteMapping("/branches/{id}")
	public void deleteBranch(@PathVariable Integer id) {
		branchRepository.deleteById(id);
	}

}
