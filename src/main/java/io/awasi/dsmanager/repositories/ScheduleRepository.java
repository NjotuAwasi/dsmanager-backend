package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	
	public List<Schedule> findBySchoolId(Integer id);
	
	public Integer countBySchoolId(Integer id);

}
