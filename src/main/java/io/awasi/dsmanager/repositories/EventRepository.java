package io.awasi.dsmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
