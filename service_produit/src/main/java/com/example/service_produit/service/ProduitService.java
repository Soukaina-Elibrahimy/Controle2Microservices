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

    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit obtenirProduit(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    public List<Produit> listerProduits() {
        return produitRepository.findAll();
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
