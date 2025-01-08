package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Evenement;

import java.util.Date;
import java.util.List;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
    Evenement findByDescription(String d);
    List<Evenement>  findByDateDebutBetween(Date dd, Date df);
}
