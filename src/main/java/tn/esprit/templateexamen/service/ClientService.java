package tn.esprit.templateexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.templateexamen.entite.Client;
import tn.esprit.templateexamen.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }
}

