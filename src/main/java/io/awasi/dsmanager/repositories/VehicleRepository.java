package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	public List<Vehicle> findBySchoolId(Integer id);
	
	public Integer countBySchoolId(Integer id);
}
