package fr.istic.taa.repository;

import fr.istic.taa.model.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreneauRepository extends JpaRepository<Creneau,Long> {

    @Query("select e.creneau from Rdv as e where e.id=?1 ")
    Optional<Creneau> findByRdv(Long rdvId);

    @Query("select e.creneaux from Prof as e where e.id=?1 ")
    List<Creneau> findByUser(Long userId);

}
