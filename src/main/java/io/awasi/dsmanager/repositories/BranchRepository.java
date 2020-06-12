package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	public List<Branch> findBySchoolId(Integer id);
	
	public Integer countBySchoolId(Integer id);
	
}
