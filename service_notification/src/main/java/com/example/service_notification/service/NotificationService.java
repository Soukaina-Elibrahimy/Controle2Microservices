package com.example.service_notification.service;

import com.example.service_notification.config.RestTemplate;
import com.example.service_notification.dto.ProduitDto;
import com.example.service_notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void fetchProduitDetails(Long produitId) {
        String url = "http://service-produits/api/produits/" + produitId;
        ProduitDto produit = restTemplate.getForObject(url, ProduitDto.class);
        System.out.println("Détails du produit : " + produit);
    }

    @KafkaListener(topics = "produitTopic", groupId = "notification")
    public void consumeProduitMessage(String message) {
        System.out.println("Message reçu : " + message);
        // Logique pour traiter la notification
    }
}
