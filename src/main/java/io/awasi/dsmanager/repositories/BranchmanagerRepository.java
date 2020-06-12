package io.awasi.dsmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Branchmanager;
import io.awasi.dsmanager.entities.BranchmanagerPK;

public interface BranchmanagerRepository extends JpaRepository<Branchmanager, BranchmanagerPK>{
	
	public Branchmanager findByUsers1Id(Integer UsersId);
	
	public Optional<Branchmanager> findByBranchmanagerPKId(Integer id);
	
	public void deleteByBranchmanagerPKId(Integer id);
	
	public void deleteByUsers1Id(Integer id);
	
	public List<Branchmanager> findBranchmanagerByUsers1SchoolId(Integer id);
	
	public List<Branchmanager> findBranchmanagerByUsers1BranchId(Integer id);

	public Integer countByUsers1BranchId(Integer id);

	
}
