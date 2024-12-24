package com.example.service_produit.service;

import com.example.service_produit.model.Produit;
import com.example.service_produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
        // Envoyer un message Kafka
        kafkaTemplate.send("produitTopic", "Produit mis à jour : " + produit.getId());
    }
}
