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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nomClient;
    private String numTel;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Colis> colis;
}

