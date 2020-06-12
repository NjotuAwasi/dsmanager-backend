package io.awasi.dsmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

}
