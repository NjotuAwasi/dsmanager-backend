package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	public List<Review> findBySchoolId(Integer id);
}
