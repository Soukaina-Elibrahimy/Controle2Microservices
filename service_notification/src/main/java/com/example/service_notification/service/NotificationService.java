package com.example.service_notification.service;

import com.example.service_notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "commandeTopic", groupId = "notifications")
    public void consommerMessage(String message) {
        System.out.println("Notification reçue : " + message);
        com.example.service_notification.model.Notification notification = new Notification();
        notification.setMessage(message);
        notificationRepository.save(notification);
    }
}
