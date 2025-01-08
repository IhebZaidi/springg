package tn.esprit.templateexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Client;
import tn.esprit.templateexamen.entite.Colis;
import tn.esprit.templateexamen.repository.ClientRepository;
import tn.esprit.templateexamen.repository.ColisRepository;

@Service
public class ColisService {

    @Autowired
    private ColisRepository colisRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Colis ajouterColisEtAffecterColisAClient(Colis colis, Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        colis.setClient(client);
        return colisRepository.save(colis);
    }
}

