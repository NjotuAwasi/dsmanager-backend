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

import io.awasi.dsmanager.entities.Session;
import io.awasi.dsmanager.entities.Vehicle;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.SessionRepository;
import io.awasi.dsmanager.repositories.UsersRepository;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SessionController {

	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	UsersRepository usersRepository;

	@GetMapping("/session/{id}")
	public Optional<Session> findSession(@PathVariable Integer id){
		return sessionRepository.findById(id);
	}
	
	@GetMapping("/sessions")
	public List<Session> findSessions(){
		return sessionRepository.findAll();
	}
	
	@GetMapping("/sessions/{id}")
	public List<Session> findSessionsBySchool(@PathVariable Integer id){
		return sessionRepository.findBySchoolId(id);
	}
	
	@PostMapping("/sessions/{id}/{user}")
	public Session addSession(@RequestBody Session session, @PathVariable Integer id, @PathVariable Integer user) {
		session.setSchool(schoolRepository.findById(id).get());
		return sessionRepository.save(session);
	}
	
	@PutMapping("/sessions")
	public Session updateVehicle(@RequestBody Session session) {
		return sessionRepository.save(session);
	}
	
	@Transactional
	@DeleteMapping("/sessions/{id}")
	public void deleteSession(@PathVariable Integer id) {
		sessionRepository.deleteById(id);
	}

}
