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

import io.awasi.dsmanager.entities.Instructor;
import io.awasi.dsmanager.entities.Vehicle;
import io.awasi.dsmanager.repositories.InstructorRepository;
import io.awasi.dsmanager.repositories.SchoolRepository;
import io.awasi.dsmanager.repositories.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class VehicleController {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	InstructorRepository instructorRepository;

	@GetMapping("/vehicle/{id}")
	public Optional<Vehicle> findVehicle(@PathVariable Integer id){
		return vehicleRepository.findById(id);
	}
	
	@GetMapping("/count/{id}")
	public Integer countVehicles(@PathVariable Integer id){
		return vehicleRepository.countBySchoolId(id);
	}
	
	@GetMapping("/vehicles")
	public List<Vehicle> findVehicles(){
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/vehicles/{id}")
	public List<Vehicle> findVehiclesBySchool(@PathVariable Integer id){
		return vehicleRepository.findBySchoolId(id);
	}
	
	@PostMapping("/vehicles/{id}/{instructor}")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id,@PathVariable Integer instructor) {
		vehicle.setSchool(schoolRepository.findById(id).get());
		Instructor ins = new Instructor();
		ins = instructorRepository.findByInstructorPKId(instructor).get();
		vehicle.setInstructor(ins);
		return vehicleRepository.save(vehicle);
	}
	
	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	@Transactional
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicle(@PathVariable Integer id) {
		vehicleRepository.deleteById(id);
	}

}
