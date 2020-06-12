package io.awasi.dsmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.awasi.dsmanager.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	public List<Notification> findBySchoolId(Integer id);
}
