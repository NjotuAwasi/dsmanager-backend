package io.awasi.dsmanager.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import io.awasi.dsmanager.entities.Instructor;
import io.awasi.dsmanager.entities.Schedule;
import io.awasi.dsmanager.entities.Student;
import io.awasi.dsmanager.repositories.InstructorRepository;
import io.awasi.dsmanager.repositories.ScheduleRepository;
import io.awasi.dsmanager.repositories.StudentRepository;
import io.awasi.dsmanager.service.EmailService;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ScheduleController {
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	@GetMapping("/schedules")
	public List<Schedule> getSchedules(){
		return scheduleRepository.findAll();
	}
	
	@GetMapping("/count/{id}")
	public Integer countSchedule(@PathVariable Integer id){
		return (int) scheduleRepository.count();
	}
	
	@GetMapping("/school/{id}")
	public List<Schedule> getSchedulesBySchool(@PathVariable Integer id){
		return scheduleRepository.findBySchoolId(id);
	}
	
	@GetMapping("/schedules/{id}")
	public Optional<Schedule> getSchedule(@PathVariable Integer id) {
		return scheduleRepository.findById(id);
	}
	
	@PostMapping("/schedules")
	public Schedule addSchedule(@RequestBody Schedule schedule) {
		int i = (int) scheduleRepository.count()+ 1;
		schedule.setId(i);
		scheduleRepository.save(schedule);
		ArrayList<Student> students = new ArrayList<Student>();
		students = (ArrayList<Student>) studentRepository.findAll();
		for (int u = 0; u <= students.size() - 1; u++) {
			Student student = new Student();
			student = students.get(u);
			emailService.sendEmailforShedule(student.getUsers1(), schedule);
		}
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		instructors = (ArrayList<Instructor>) instructorRepository.findAll();
		for (int u = 0; u <= instructors.size() - 1; u++) {
			Instructor instructor = new Instructor();
			instructor = instructors.get(u);
			emailService.sendEmailforSheduleInstructor(instructor.getUsers1(), schedule);
		}
		return scheduleRepository.save(schedule);
	}
	@PutMapping("/schedules")
	public Schedule updateSchedule(@RequestBody Schedule schedule) {
		System.out.println(schedule.getSubject());
		return scheduleRepository.save(schedule);
	}
	@DeleteMapping("/schedules/{id}")
	public void deleteSchedule(@PathVariable Integer id) {
		scheduleRepository.deleteById(id);
	}

}
