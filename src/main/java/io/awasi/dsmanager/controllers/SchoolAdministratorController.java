package io.awasi.dsmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.School;
import io.awasi.dsmanager.entities.Schooladministrator;
import io.awasi.dsmanager.entities.SchooladministratorPK;
import io.awasi.dsmanager.entities.Userrole;
import io.awasi.dsmanager.entities.UserrolePK;
import io.awasi.dsmanager.entities.Users;
import io.awasi.dsmanager.repositories.SchoolAdministratorRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.UserRoleRepository;
import io.awasi.dsmanager.repositories.UsersRepository;

@RestController
@RequestMapping("/schooladministrators")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SchoolAdministratorController {

	@Autowired
	SchoolAdministratorRepository schoolAdministratorRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@PostMapping("/schooladministrator")
	public Schooladministrator addSchoolAdministrator(@RequestBody Schooladministrator schooladministrator){
		
		School school = schooladministrator.getUsers1().getSchool();
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		Users users = schooladministrator.getUsers1();
		schoolRepository.save(school);
		
		schooladministrator.setUsers1(users);
		schooladministrator.getUsers1().setSchool(school);
		System.out.print(schooladministrator);
		usersRepository.save(users);
		
		int u = (int) (userRoleRepository.count() + 1);
		userrolePK.setRole(3);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepository.save(userrole);
		
		int i = (int) schoolAdministratorRepository.count() + 1;
		SchooladministratorPK schooladministratorPK = new SchooladministratorPK();
		schooladministratorPK.setUsers(users.getId());
		schooladministratorPK.setId(i);
		schooladministratorPK.setSchool(school.getId());
		schooladministrator.setSchooladministratorPK(schooladministratorPK);
		
		return schoolAdministratorRepository.save(schooladministrator);
	}
}
