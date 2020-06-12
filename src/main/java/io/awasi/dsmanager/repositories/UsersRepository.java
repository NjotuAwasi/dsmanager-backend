package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.School;
import io.awasi.dsmanager.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public List<Users> findBySchoolId(Integer schoolId);
	
    public boolean existsByLoginAndPassword(String login, String password);
    
    public Users findByLoginAndPassword(String login, String password);
    
    public School findSchoolByLoginAndPassword(String login, String password);
}
