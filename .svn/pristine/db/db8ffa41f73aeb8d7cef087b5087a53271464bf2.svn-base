package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer>{
	
	@Query("SELECT n from Notification n where n.sender=:id AND n.isActive=1")
	List<Notification> getNotificationByUserId(Integer id);

}
