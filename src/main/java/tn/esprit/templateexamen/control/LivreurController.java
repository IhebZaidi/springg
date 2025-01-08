package tn.esprit.templateexamen.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.templateexamen.entite.Livreur;
import tn.esprit.templateexamen.service.LivreurService;

import java.util.List;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {

    @Autowired
    private LivreurService livreurService;

    @PostMapping
    public void ajouterLivreurEtAffecterColisALivreur(@RequestBody Livreur livreur, @RequestParam List<String> referencesColis) {
        livreurService.ajouterLivreurEtAffecterColisALivreur(livreur, referencesColis);
    }
}

