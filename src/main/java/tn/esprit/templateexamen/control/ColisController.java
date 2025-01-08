package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.templateexamen.entite.Colis;
import tn.esprit.templateexamen.service.ColisService;

@RestController
@RequestMapping("/colis")
public class ColisController {

    @Autowired
    private ColisService colisService;

    @PostMapping("/{idClient}")
    public Colis ajouterColisEtAffecterColisAClient(@RequestBody Colis colis, @PathVariable Long idClient) {
        return colisService.ajouterColisEtAffecterColisAClient(colis, idClient);
    }
}
