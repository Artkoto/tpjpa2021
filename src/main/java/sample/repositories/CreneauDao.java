package sample.repositories ;

import sample.domain.Creneau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreneauDao extends JpaRepository<Creneau, Long> {


}
