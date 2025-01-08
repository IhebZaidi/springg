package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Logistique;
@Repository
public interface LogistiqueRepo extends JpaRepository<Logistique, Integer> {
}
