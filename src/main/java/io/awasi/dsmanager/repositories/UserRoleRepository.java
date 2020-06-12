package io.awasi.dsmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Userrole;

public interface UserRoleRepository extends JpaRepository<Userrole, Integer>{
	
}
