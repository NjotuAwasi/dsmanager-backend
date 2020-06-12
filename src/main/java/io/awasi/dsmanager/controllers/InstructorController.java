package io.awasi.dsmanager.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.awasi.dsmanager.entities.Instructor;
import io.awasi.dsmanager.entities.InstructorPK;
import io.awasi.dsmanager.entities.Userrole;
import io.awasi.dsmanager.entities.UserrolePK;
import io.awasi.dsmanager.entities.Users;
import io.awasi.dsmanager.repositories.InstructorRepository;
import io.awasi.dsmanager.repositories.UserRoleRepository;
import io.awasi.dsmanager.repositories.UsersRepository;
import io.awasi.dsmanager.service.EmailService;

@RestController
@RequestMapping("/instructors")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class InstructorController {

	@Autowired
	InstructorRepository instructorRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UserRoleRepository userRoleRepo;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("/instructors")
	public List<Instructor> getInstructor(){
		return instructorRepository.findAll();
	}
	
	@GetMapping("/count/{id}")
	public Integer countInstructor(@PathVariable Integer id){
		return instructorRepository.countByUsers1SchoolId(id);
	}
	
	@RequestMapping("/count/branch/{id}")
	public Integer countStudents(@PathVariable Integer id){
		return instructorRepository.countByUsers1BranchId(id);
	}
	
	@RequestMapping("/school/{id}")
	public List<Instructor> getInstructorBySchool(@PathVariable Integer id){
		return instructorRepository.findInstructorByUsers1SchoolId(id);
	}
	@RequestMapping("/instructor/{id}")
	public Optional<Instructor> getInstructor(@PathVariable Integer id){
		return instructorRepository.findByInstructorPKId(id);
	}
	@Transactional
	@DeleteMapping("/instructors/{id}")
	public void deleteInstructor(@PathVariable Integer id){
		Optional<Instructor> insid = instructorRepository.findByInstructorPKId(id);
		Integer ins = insid.get().getInstructorPK().getUsers();
		instructorRepository.deleteByInstructorPKId(id);
		usersRepository.deleteById(ins);
	}
	@PostMapping("/instructors")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		Users users = instructor.getUsers1();
		instructor.getUsers1().setSchool(null);
		usersRepository.save(users);
		
		int u = (int) (userRoleRepo.count() + 1);
		userrolePK.setRole(4);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepo.save(userrole);
		
		try {
			emailService.sendEmail(users);
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		
		int i = (int) instructorRepository.count() + 1;
		InstructorPK instructorPK = new InstructorPK(users.getId(), i);
		instructor.setInstructorPK(instructorPK);
		instructor.setUsers1(users);
		return instructorRepository.save(instructor);
	}
	@PutMapping("/instructors")
	public Instructor updateInstructor(@RequestBody Instructor instructor){
		Users users = instructor.getUsers1();
		usersRepository.save(users);
		System.out.print(instructor);
		return instructorRepository.save(instructor);
	}
}
