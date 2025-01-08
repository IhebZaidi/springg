package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.entite.Tache;

import java.util.List;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Integer> {
    Participant findByNomAndPrenom(String n,String p);
    List<Participant>  findByTache(Tache t);
}
