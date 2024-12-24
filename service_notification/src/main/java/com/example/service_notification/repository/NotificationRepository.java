package com.example.service_notification.repository;

import com.example.service_notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  NotificationRepository extends JpaRepository<Long, Notification> {
}
