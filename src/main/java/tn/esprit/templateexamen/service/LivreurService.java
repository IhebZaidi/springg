package tn.esprit.templateexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Colis;
import tn.esprit.templateexamen.entite.Livreur;
import tn.esprit.templateexamen.repository.ColisRepository;
import tn.esprit.templateexamen.repository.LivreurRepository;

import java.util.List;

@Service
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

    @Autowired
    private ColisRepository colisRepository;

    public void ajouterLivreurEtAffecterColisALivreur(Livreur livreur, List<String> referencesColis) {
        List<Colis> colisList = colisRepository.findByReferenceColisIn(referencesColis);

        livreur.setColis(colisList);
        for (Colis colis : colisList) {
            colis.setLivreur(livreur);
        }
        livreurRepository.save(livreur);
    }
}

