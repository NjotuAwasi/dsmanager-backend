package io.awasi.dsmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Instructor;
import io.awasi.dsmanager.entities.InstructorPK;

public interface InstructorRepository extends JpaRepository<Instructor, InstructorPK>{

	public Optional<Instructor> findByInstructorPKId(Integer id);
	
	public void deleteByInstructorPKId(Integer id);
	
	public void deleteByUsers1Id(Integer id);
	
	public List<Instructor> findInstructorByUsers1SchoolId(Integer id);
	
	public Integer countByUsers1BranchId(Integer id);
	
	public Integer countByUsers1SchoolId(Integer id);
}
