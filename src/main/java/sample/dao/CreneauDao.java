package sample.dao ;

import sample.domain.Creneau;

import java.util.List;

import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CreneauDao extends JpaRepository<Creneau, Long> {

    @Query("select a.creneau from Appointment as a where a.id=?1 ")
    Optional<Creneau> findByRdv(Long rdvId);

    @Query("select e.creneaux from Prof as e where e.id=?1 ")
    List<Creneau> findByUser(Long userId);
    
}
