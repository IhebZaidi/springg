package tn.esprit.templateexamen.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private float cout;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Logistique> Logistiques;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Participant> participants;
}
