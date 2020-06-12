package io.awasi.dsmanager.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import io.awasi.dsmanager.entities.Student;
import io.awasi.dsmanager.entities.StudentPK;
import io.awasi.dsmanager.entities.Userrole;
import io.awasi.dsmanager.entities.UserrolePK;
import io.awasi.dsmanager.entities.Users;
import io.awasi.dsmanager.repositories.BranchRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.StudentRepository;
import io.awasi.dsmanager.repositories.UserRoleRepository;
import io.awasi.dsmanager.repositories.UsersRepository;
import io.awasi.dsmanager.service.EmailService;
import io.awasi.dsmanager.util.GeneratePdfReport;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
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
	
	@RequestMapping("/students")
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	 @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> StudentsReport() throws DocumentException, MalformedURLException, IOException {
		 	List<Student> students = studentRepository.findAll();
		 	students = studentRepository.findAll();
	        //List<Student> students = (List<Student>) studentRepository.findAll();

		 	System.out.print(students);
	        ByteArrayInputStream bis = GeneratePdfReport.StudentReport(students);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=studentsreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	
	@GetMapping("/count/{id}")
	public Integer countStudents(@PathVariable Integer id){
		return studentRepository.countByUsers1SchoolId(id);
	}
	
	@RequestMapping("/count/branch/{id}")
	public Integer CountStudents(@PathVariable Integer id){
		return studentRepository.countByUsers1BranchId(id);
	}
	
	@RequestMapping("/school/{id}")
	public List<Student> getStudentBySchool(@PathVariable Integer id){
		return studentRepository.findStudentByUsers1SchoolId(id);
	}
	
	@RequestMapping("/school/{id}/{status}")
	public List<Student> getStudentBySchoolAndStatus(@PathVariable Integer id, @PathVariable String status){
		return studentRepository.findStudentByUsers1SchoolIdAndStatus(id, status);
	}
	
	@RequestMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id){
		return studentRepository.findByStudentPKId(id);
	}
	
	@RequestMapping("/studentuser/{id}")
	public Student getStudentByUsers(@PathVariable Integer id){
		return studentRepository.findByStudentPKUsers(id);
	}
	
	@RequestMapping("/review/{id}")
	public ArrayList<Student> getReview(@PathVariable Integer id){
		ArrayList<Student> students = new ArrayList<Student>();
		students = (ArrayList<Student>) studentRepository.findStudentByUsers1SchoolId(id);
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i = 0; i < students.size(); i++) {
			Student student = new Student();
			student = students.get(i);
			if (student.getReview() != null) {
				list.add(student);
			}
		}
		return list;
	}
	
	@Transactional
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Integer id){
		Optional<Student> studid = studentRepository.findByStudentPKId(id);
		Integer stud = studid.get().getStudentPK().getUsers();
		studentRepository.deleteByStudentPKId(id);
		usersRepository.deleteById(stud);
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student){
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		Users users = student.getUsers1();
		student.getUsers1().setSchool(null);
		usersRepository.save(users);
		
		int u = (int) (userRoleRepo.count() + 1);
		userrolePK.setRole(2);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepo.save(userrole);
		
		try {
			emailService.sendEmail(users);
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		
		int i = (int) studentRepository.count() + 1;
		StudentPK studentPk = new StudentPK(users.getId(), i);
		student.setStudentPK(studentPk);
		student.setUsers1(users);
		student.setReview(null);
		return studentRepository.save(student);
	}
	
	@PostMapping("/students/{id}")
	public Student addStudentBySchool(@RequestBody Student student, @PathVariable Integer id){
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		Users users = student.getUsers1();
		student.getUsers1().setSchool(schoolRepository.findById(id).get());
		usersRepository.save(users);
		
		int u = (int) (userRoleRepo.count() + 1);
		userrolePK.setRole(2);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepo.save(userrole);
		
		try {
			emailService.sendEmail(users);
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		
		int i = (int) studentRepository.count() + 5;
		StudentPK studentPk = new StudentPK(users.getId(), i);
		student.setStudentPK(studentPk);
		student.setUsers1(users);
		student.setReview(null);
		return studentRepository.save(student);
	}
	@PostMapping("/students/{school}/{branch}")
	public Student addStudentBySchoolAndBranch(@RequestBody Student student, @PathVariable Integer school, @PathVariable Integer branch){
		
		Userrole userrole = new Userrole();
		UserrolePK userrolePK = new UserrolePK();
		
		Users users = student.getUsers1();
		student.getUsers1().setSchool(schoolRepository.findById(school).get());
		student.getUsers1().setBranch(branchRepository.findById(branch).get());
		usersRepository.save(users);
		
		int u = (int) (userRoleRepo.count() + 1);
		userrolePK.setRole(2);
		userrolePK.setId(u);
		userrolePK.setUsers(users.getId());
		userrole.setUserrolePK(userrolePK);
		userRoleRepo.save(userrole);
		
		try {
			emailService.sendEmail(users);
		}catch(MailException e) {
			System.out.println(e.getMessage());
		}
		
		int i = (int) studentRepository.count() + 1;
		StudentPK studentPk = new StudentPK(users.getId(), i);
		student.setStudentPK(studentPk);
		student.setUsers1(users);
		return studentRepository.save(student);
	}
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student){
		Users users = student.getUsers1();
		usersRepository.save(users);
		System.out.print(student);
		return studentRepository.save(student);
		
	}
	@RequestMapping("/stud")
	public Student getStudentByUser(Integer usersId){
		 return studentRepository.findByUsers1Id(2);
	 }
}
