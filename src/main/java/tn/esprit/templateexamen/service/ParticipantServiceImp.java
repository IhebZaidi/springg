package tn.esprit.templateexamen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Evenement;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.entite.Tache;
import tn.esprit.templateexamen.repository.ParticipantRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ParticipantServiceImp implements IParticipantService{
    ParticipantRepo participantRepo;
    @Override
    public Participant ajouterParticipant(Participant p) {
        return participantRepo.save(p);
    }

    @Override
    public List<Participant> getParReservLogis() {
        List<Participant> l = new ArrayList<>();
        Tache t = Tache.ORGANISATEUR;
        List<Participant> l1 = participantRepo.findByTache(t);
        for (Participant p : l1) {
            Set<Evenement> es = p.getEvenements();
            for (Evenement e : es) {
                if (e.getLogistiques().isEmpty()) {
                    l.add(p);
                    break;
                }
            }
        }
        return l;
    }
}
