package io.awasi.dsmanager.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.Branchmanager;
import io.awasi.dsmanager.entities.BranchmanagerPK;
import io.awasi.dsmanager.entities.Userrole;
import io.awasi.dsmanager.entities.UserrolePK;
import io.awasi.dsmanager.entities.Users;
import io.awasi.dsmanager.repositories.BranchRepository;
import io.awasi.dsmanager.repositories.BranchmanagerRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.UserRoleRepository;
import io.awasi.dsmanager.repositories.UsersRepository;
import io.awasi.dsmanager.service.EmailService;

@RestController
@RequestMapping("/branchmanagers")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BranchmanagerController {

	@Autowired
	BranchmanagerRepository branchmanagerRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UserRoleRepository userRoleRepo;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("/branchmanagers")
	public List<Branchmanager> getBranchmanagers(){
		return branchmanagerRepository.findAll();
	}
	
	@RequestMapping("/count/branch/{id}")
	public Integer countBranchmanagers(@PathVariable Integer id){
		return branchmanagerRepository.countByUsers1BranchId(id);
	}
	
	@RequestMapping("/school/{id}")
	public List<Branchmanager> getBranchmanagerBySchool(@PathVariable Integer id){
		return branchmanagerRepository.findBranchmanagerByUsers1SchoolId(id);
	}
	
	@RequestMapping("/school/branch/{id}")
	public List<Branchmanager> getBranchmanagerBySchoolandBranch(@PathVariable Integer id){
		return branchmanagerRepository.findBranchmanagerByUsers1BranchId(id);
	}
	
	@RequestMapping("/branchmanagers/{id}")
	public Optional<Branchmanager> getBranchmanager(@PathVariable Integer id){
		return branchmanagerRepository.findByBranchmanagerPKId(id);
	}
	@Transactional
	@DeleteMapping("/branchmanagers/{id}")
	public void deleteBranchmanager(@PathVariable Integer id){
		Optional<Branchmanager> branchid = branchmanagerRepository.findByBranchmanagerPKId(id);
		Integer branch = branchid.get().getBranchmanagerPK().getUsers();
		branchmanagerRepository.deleteByBranchmanagerPKId(id);
		usersRepository.deleteById(branch);
	}
	
	@PostMapping("/branchmanagers/{school}/{branch}")
	public Branchmanager addBranchManagerBySchoolAndBranch(@RequestBody Branchmanager branchmanager, @PathVariable Integer school, @PathVariable Integer branch){
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		System.out.print(branch);
		Users users = branchmanager.getUsers1();
		branchmanager.getUsers1().setSchool(schoolRepository.findById(school).get());
		branchmanager.getUsers1().setBranch(branchRepository.findById(branch).get());
		usersRepository.save(users);
		
		int u = (int) (userRoleRepo.count() + 1);
		userrolePK.setRole(5);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepo.save(userrole);
		
		try {
			emailService.sendEmail(users);
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		
		int i = (int) branchmanagerRepository.count() + 1;
		BranchmanagerPK branchmanagerPK = new BranchmanagerPK(users.getId(), i);
		branchmanager.setBranchmanagerPK(branchmanagerPK);
		branchmanager.setBranch(branchRepository.findById(branch).get());
		branchmanager.setUsers1(users);
		System.out.print(branchmanager);
		return branchmanagerRepository.save(branchmanager);
	}
	@PutMapping("/branchmanagers")
	public Branchmanager updateBranchmanager(@RequestBody Branchmanager branchmanager){
		Users users = branchmanager.getUsers1();
		usersRepository.save(users);
		System.out.print(branchmanager);
		return branchmanagerRepository.save(branchmanager);
		
	}
}
