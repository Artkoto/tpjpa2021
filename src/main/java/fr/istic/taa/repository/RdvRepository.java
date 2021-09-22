package fr.istic.taa.repository;

import fr.istic.taa.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {
    @Query("select e from Rdv as e where e.title = ?1")
    List<Rdv> findByTitle(String s);

    @Query("select e from Rdv as e where e.prof.id =?1 or e.client.id =?1")
    List<Rdv> findByUser(Long id) ;

    @Query("select e from Rdv as e where e.creneau.id = ?1")
    List<Rdv> findByCrenel(long id) ;

}
