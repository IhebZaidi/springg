package tn.esprit.templateexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Colis;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
    Optional<Colis> findByReferenceColis(String referenceColis);

    List<Colis> findByReferenceColisIn(List<String> referencesColis);

}

