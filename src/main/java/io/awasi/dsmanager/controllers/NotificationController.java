package io.awasi.dsmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.awasi.dsmanager.entities.Notification;
import io.awasi.dsmanager.repositories.NotificationRepository;

@RestController
@RequestMapping("/schoollog")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class NotificationController {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@GetMapping("/notifications")
	public List<Notification> findNotifications(){
		return notificationRepository.findAll();
	}
	
	@GetMapping("/notifications/{id}")
	public List<Notification> findNotificationsBySchool(@PathVariable Integer id){
		return notificationRepository.findBySchoolId(id);
	}

}
