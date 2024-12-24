package com.example.service_produit.controller;

import com.example.service_produit.model.Produit;
import com.example.service_produit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    @GetMapping("/{id}")
    public Produit obtenirProduit(@PathVariable Long id) {
        return produitService.obtenirProduit(id);
    }

    @GetMapping
    public List<Produit> listerProduits() {
        return produitService.listerProduits();
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
}
