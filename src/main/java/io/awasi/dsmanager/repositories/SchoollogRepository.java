package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Schoollog;

public interface SchoollogRepository extends JpaRepository<Schoollog, Integer>{
	
	public List<Schoollog> findBySchoolId(Integer id);

}
