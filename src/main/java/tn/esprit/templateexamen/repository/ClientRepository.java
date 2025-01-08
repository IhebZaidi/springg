package tn.esprit.templateexamen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

