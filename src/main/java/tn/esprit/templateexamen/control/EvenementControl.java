package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.templateexamen.entite.Evenement;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.service.IEvenementService;

@RestController

@RequestMapping("/evenement")
public class EvenementControl {
    @Autowired
    IEvenementService evenementService;

    // http://localhost:8089/assurance/evenement/add-evenement
    @PostMapping("/add-evenement")
    public Evenement addChaeazembre(@RequestBody Evenement c) {
        Evenement chambre = evenementService.ajoutAffectEvenParticip(c);
        return chambre;
    }
}
