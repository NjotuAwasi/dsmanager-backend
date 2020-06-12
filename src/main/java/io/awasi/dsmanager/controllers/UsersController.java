package io.awasi.dsmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.School;
import io.awasi.dsmanager.entities.Users;
import io.awasi.dsmanager.repositories.UsersRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	
	@RequestMapping("/users")
	public List<Users> findAll(){
		List<Users> users= new ArrayList<>();
		usersRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	@RequestMapping("/use")
	public List<Users> getAllCourses(Integer schoolId){
		 List<Users> users = new ArrayList<>();
		 usersRepository.findBySchoolId(1)
		 .forEach(users::add);
		 return users;
	 }
	
	@GetMapping("/login/{login}/{password}")
	public boolean existLoginUser(@PathVariable String login, @PathVariable String password) {
		if(usersRepository.existsByLoginAndPassword(login, password)) {
			return true;
		}
		return false;
	}
	@GetMapping("/login/login/{login}/{password}")
	public Users getLoginUser(@PathVariable String login, @PathVariable String password) {
	 return usersRepository.findByLoginAndPassword(login, password);
	}
	
	@GetMapping("/login/login/school/{login}/{password}")
	public School getSchool(@PathVariable String login, @PathVariable String password) {
	 return usersRepository.findSchoolByLoginAndPassword(login, password);
	}
}
