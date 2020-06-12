package io.awasi.dsmanager.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import io.awasi.dsmanager.entities.Schedule;
import io.awasi.dsmanager.entities.Users;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(Users user) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("awasinjotu@gmail.com");
		mail.setSubject("registration");
		mail.setText("your username is: " + user.getLogin() + " and password: " + user.getPassword() +"\n You can change you password after logging in");
		javaMailSender.send(mail);
	}
	
	public void sendEmailforShedule(Users user, Schedule schedule) throws MailException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy"); 
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("awasinjotu@gmail.com");
		mail.setSubject("schedule class");
		mail.setText("Hello "
				+ user.getFirstname() + ", You have been scheduled for the class of "
						+ schedule.getSubject() +" at "
								+ schedule.getLocation()+ ", and on this date "
										+ formatter.format(schedule.getStartdate()) +" at 10am. Thank You");
		javaMailSender.send(mail);
	}
	public void sendEmailforSheduleInstructor(Users user, Schedule schedule) throws MailException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("awasinjotu@gmail.com");
		mail.setSubject("schedule class");
		mail.setText("Hello Mr "
				+ user.getFirstname() + ", we wish you to teach the class of "
						+ schedule.getSubject() +" at our branch in "
								+ schedule.getLocation()+ ", and on this date "
										+ formatter.format(schedule.getStartdate()) +" at 10 am. Log in to your account for more information. Thank You");
		javaMailSender.send(mail);
	}
}
