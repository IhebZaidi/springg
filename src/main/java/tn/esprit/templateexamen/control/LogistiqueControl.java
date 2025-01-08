package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.templateexamen.entite.Logistique;
import tn.esprit.templateexamen.entite.Participant;
import tn.esprit.templateexamen.service.ILogistiqueService;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/logistique")
public class LogistiqueControl {
    @Autowired
    ILogistiqueService logistiqueService;

    // http://localhost:8089/assurance/logistique/add-logistique
    @PostMapping("/add-logistique/{d}")
    public Logistique addzeaChambre(@RequestBody Logistique c,@PathVariable("d") String d) {
        return logistiqueService.ajoutAffectLogEvnm(c,d);
    }

    // http://localhost:8089/assurance/logistique/retrieve-logistique/aa/bb

    @GetMapping("/retrieve-logistique/{dd}/{df}")
    public List<Logistique> getChambres(@PathVariable("dd")@DateTimeFormat(pattern = "yyyy-MM-dd") Date dd, @PathVariable("df")@DateTimeFormat(pattern = "yyyy-MM-dd") Date df) {
        return logistiqueService.getLogistiquesDates(dd,df);
    }
}
