package sample.dao;

import sample.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvDao extends JpaRepository<Rdv, Long> {

    public Rdv getByTitle(String title);
    public Iterable<Rdv> getRdvsByCreneauId(Long id); 
    public Rdv findByTitle(String title); 

}
