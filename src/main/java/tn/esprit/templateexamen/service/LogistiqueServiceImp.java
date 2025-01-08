package tn.esprit.templateexamen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Evenement;
import tn.esprit.templateexamen.entite.Logistique;
import tn.esprit.templateexamen.repository.EvenementRepo;
import tn.esprit.templateexamen.repository.LogistiqueRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class LogistiqueServiceImp implements ILogistiqueService{
    EvenementRepo evenementRepo;
    LogistiqueRepo logistiqueRepo;
    @Override
    public Logistique ajoutAffectLogEvnm(Logistique l, String descriptionEvnmt) {
        Evenement evenement=evenementRepo.findByDescription(descriptionEvnmt);
        evenement.getLogistiques().add(l);
        return logistiqueRepo.save(l);
    }

    @Override
    public List<Logistique> getLogistiquesDates(Date dateDeb, Date dateFin) {
        List<Evenement> events = evenementRepo.findByDateDebutBetween(dateDeb, dateFin);
        List<Logistique> logisticsList = new ArrayList<>();
        for (Evenement e : events) {
            Set<Logistique> logistiques = e.getLogistiques();
            if (logistiques != null) {
                for (Logistique logistique : logistiques) {
                    logisticsList.add(logistique);
                }
            }
        }
        return logisticsList;
    }
}
