//package io.awasi.dsmanager.controllers;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.awasi.dsmanager.entities.StudentPK;
//import io.awasi.dsmanager.repo.StudentPkRepository;
//
//@RestController
//public class StudentPkController {
//
//	@Autowired
//	private StudentPkRepository studentPkRepository;
//	@RequestMapping("/test/{id}")
//	public Optional<StudentPK> getStudent(@PathVariable Integer id){
//		return studentPkRepository.findById(id);
//	}
//}
