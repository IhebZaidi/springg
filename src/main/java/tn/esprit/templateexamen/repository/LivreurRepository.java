package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Livreur;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur, Long> {
}

