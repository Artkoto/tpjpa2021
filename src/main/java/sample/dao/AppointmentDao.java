package sample.dao;

import sample.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {

    public Appointment getByTitle(String title);
    public Iterable<Appointment> getRdvsByCreneauId(Long id); 
    public Appointment findByTitle(String title); 

}
