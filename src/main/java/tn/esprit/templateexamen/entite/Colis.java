package tn.esprit.templateexamen.entite;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColis;

    private String referenceColis;
    private Float prixCommande;
    private LocalDate dateLivraison;

    @Enumerated(EnumType.STRING)
    private Etat etatColis;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "livreur_id")
    private Livreur livreur;

    @ManyToMany
    @JoinTable(
            name = "colis_produit",
            joinColumns = @JoinColumn(name = "colis_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits ;

}