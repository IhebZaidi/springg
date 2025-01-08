package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.templateexamen.entite.Logistique;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.service.IParticipantService;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/participant")
public class ParticipantControl {
    @Autowired
    IParticipantService participantService;

    // http://localhost:8089/assurance/participant/add-participant
    @PostMapping("/add-participant")
    public Participant addChambre(@RequestBody Participant c) {
        Participant chambre = participantService.ajouterParticipant(c);
        return chambre;
    }

    // http://localhost:8089/assurance/participant/retrieve-par

    @GetMapping("/retrieve-par")
    public List<Participant> getChambres() {
        return participantService.getParReservLogis();
    }
}
