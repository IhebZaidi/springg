package tn.esprit.templateexamen.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Evenement;
import tn.esprit.templateexamen.entite.Logistique;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.repository.EvenementRepo;
import tn.esprit.templateexamen.repository.ParticipantRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class EvenementServiceImp implements IEvenementService{
    EvenementRepo evenementRepo;
    ParticipantRepo participantRepo;
    @Override
    public Evenement ajoutAffectEvenParticip(Evenement e) {
        Set<Participant> participants = e.getParticipants();
        e.setParticipants(new HashSet<>());
        for (Participant participant : participants) {
            Participant existingParticipant=null;
            existingParticipant = participantRepo.findByNomAndPrenom(participant.getNom(), participant.getPrenom());
            if (existingParticipant !=null) {
                e.getParticipants().add(existingParticipant);
            }else {
                e.getParticipants().add(participant);
            }
        }
        return  evenementRepo.save(e);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    @Transactional
    //@Scheduled(cron = "*/60 * * * * *")
    public void calculCout() {
        List<Evenement> events = evenementRepo.findAll();
        for (Evenement event : events) {
            if (!event.getLogistiques().isEmpty()) {
                float totalCost = 0;
                for (Logistique logistique : event.getLogistiques()) {
                    totalCost += logistique.getPrixUnit() * logistique.getQuantite();
                }
                event.setCout(totalCost);
            }
        }
        evenementRepo.saveAll(events);
        // Log after the update
        log.info("Every 60 seconds: Update the cost of each event");
    }
}
