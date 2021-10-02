package sample.dao;

import sample.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment  as a WHERE a.creneau.id=?1")
    public Iterable<Appointment> findRdvsByCreneauId(Long id); 

    @Query("SELECT a FROM Appointment  as a WHERE a.title=?1")
    public Appointment findByTitle(String title); 

}
