package io.awasi.dsmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Student;
import io.awasi.dsmanager.entities.StudentPK;

public interface StudentRepository extends JpaRepository<Student, StudentPK>{

	public Student findByUsers1Id(Integer UsersId);
	
	public List<Student> findByStatus(String status);
	
	public Optional<Student> findByStudentPKId(Integer id);
	
	public void deleteByStudentPKId(Integer id);
	
	public void deleteByUsers1Id(Integer id);
	
	public Student findByStudentPKUsers(Integer id);
	
	public List<Student> findStudentByUsers1SchoolId(Integer id);
	
	public List<Student> findStudentByUsers1SchoolIdAndStatus(Integer id, String status);
	
	public Integer countByUsers1BranchId(Integer id);
	
	public Integer countByUsers1SchoolId(Integer id);

	
}
