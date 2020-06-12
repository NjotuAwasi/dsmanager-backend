package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Integer>{
	
	public List<Session> findBySchoolId(Integer id);

}
