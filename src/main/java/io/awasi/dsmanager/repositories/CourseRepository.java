package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public List<Course> findBySchoolId(Integer id);
	
	public Integer countBySchoolId(Integer id);

}
