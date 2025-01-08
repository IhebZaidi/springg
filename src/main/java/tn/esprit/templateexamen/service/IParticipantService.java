package tn.esprit.templateexamen.service;

import tn.esprit.templateexamen.entite.Participant;

import java.util.List;

public interface IParticipantService {
    public Participant ajouterParticipant (Participant p);
    public List<Participant> getParReservLogis ( );
}
