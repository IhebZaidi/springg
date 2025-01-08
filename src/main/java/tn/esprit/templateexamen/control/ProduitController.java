package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.templateexamen.entite.Produit;
import tn.esprit.templateexamen.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Endpoint pour ajouter un produit
    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    // Endpoint pour affecter un produit à un colis
    @PostMapping("/{idProduit}/affecter/{referenceColis}")
    public void affecterProduitAColis(@PathVariable Long idProduit, @PathVariable String referenceColis) {
        produitService.affecterProduitAColis(idProduit, referenceColis);
    }

    // Endpoint pour récupérer tous les produits
    @GetMapping
    public List<Produit> listerProduits() {
        return produitService.listerProduits();
    }
}

