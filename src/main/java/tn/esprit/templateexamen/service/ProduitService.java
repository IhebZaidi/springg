package tn.esprit.templateexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Colis;
import tn.esprit.templateexamen.entite.Produit;
import tn.esprit.templateexamen.repository.ColisRepository;
import tn.esprit.templateexamen.repository.ProduitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ColisRepository colisRepository;

    // Ajouter un produit
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Affecter un produit à un colis
    public void affecterProduitAColis(Long idProduit, String referenceColis) {
        Produit produit = produitRepository.findById(idProduit)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        Colis colis = colisRepository.findByReferenceColis(referenceColis)
                .orElseThrow(() -> new RuntimeException("Colis non trouvé"));

        if (colis.getProduits() == null) {
            colis.setProduits(new ArrayList<>());
        }

        colis.getProduits().add(produit);

        if (produit.getColis() == null) {
            produit.setColis(new ArrayList<>());
        }

        produit.getColis().add(colis);

        // Sauvegarde des modifications
        colisRepository.save(colis);
        produitRepository.save(produit);
    }

    // Récupérer la liste des produits
    public List<Produit> listerProduits() {
        return produitRepository.findAll();
    }
}
