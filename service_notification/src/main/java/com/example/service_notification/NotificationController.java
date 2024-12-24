package com.example.service_notification;

import com.example.service_notification.model.Notification;
import com.example.service_notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> obtenirToutesLesNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Notification obtenirNotificationParId(@PathVariable Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification non trouvée"));
    }
}
