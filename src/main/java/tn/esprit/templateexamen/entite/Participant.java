package tn.esprit.templateexamen.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPart;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Tache tache;

    @ManyToMany(mappedBy="participants", cascade = CascadeType.ALL)
    private Set<Evenement> evenements;
}
