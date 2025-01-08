package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}


