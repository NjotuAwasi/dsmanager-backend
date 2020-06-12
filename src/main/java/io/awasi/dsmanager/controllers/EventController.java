package io.awasi.dsmanager.controllers;

import java.util.List;

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

import io.awasi.dsmanager.entities.Event;
import io.awasi.dsmanager.repositories.EventRepository;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EventController {

	@Autowired
	EventRepository eventRepository;
	
	@GetMapping("/events")
	public List<Event> findEvents(){
		return eventRepository.findAll();
	}
	
	@PostMapping("/events")
	public Event addEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}
	
	@PutMapping("/events}")
	public Event updateEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}
	
	@Transactional
	@DeleteMapping("/branches/{id}")
	public void deleteEvent(@PathVariable Integer id) {
		eventRepository.deleteById(id);
	}
}
