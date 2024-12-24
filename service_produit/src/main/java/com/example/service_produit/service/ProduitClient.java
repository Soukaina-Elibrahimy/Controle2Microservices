package com.example.service_produit.service;

import com.example.service_produit.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProduitClient {
    @Autowired
    private RestTemplate restTemplate;
    public Produit obtenirProduit(Long produitId) {
        return restTemplate.getForObject("http://service-produits/api/produits/" + produitId, Produit.class);
    }
}
