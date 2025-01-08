package tn.esprit.templateexamen.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Livreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivreur;

    private String nomLivreur;
    private String prenomLivreur;

    @OneToMany(mappedBy = "livreur", cascade = CascadeType.ALL)
    private List<Colis> colis;

    // Getters et Setters
}