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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String identifiant;

    @Enumerated(EnumType.STRING)
    private Categorie categorieProd;

    @ManyToMany(mappedBy = "produits")
    private List<Colis> colis;

    // Getters et Setters
}
