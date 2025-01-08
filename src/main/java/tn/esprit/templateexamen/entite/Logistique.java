package tn.esprit.templateexamen.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Logistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLog;
    private String description;
    private boolean reserve;
    private float prixUnit;
    private int quantite;
}
