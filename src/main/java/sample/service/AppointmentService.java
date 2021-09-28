package sample.service;


import lombok.Data;
import sample.dao.AppointmentDao;
import sample.domain.Appointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Data
public class AppointmentService {

    @Autowired
    private AppointmentDao rdvDao; 

    public Optional<Appointment> getAppointment(final Long id){
        return rdvDao.findById(id);
    }

    public Iterable<Appointment> getAppointments()   {
        return rdvDao.findAll();
    }
    public Appointment getAppointmentByTitle(String title)   {
        return rdvDao.findByTitle(title);
    }

    public void  deleteAppointment(final Long id){
        if (rdvDao.existsById(id)) {
            rdvDao.deleteById(id);
        }
    }

    public Appointment saveAppointment(Appointment rdv){
        return rdvDao.save(rdv);
    }
    public Appointment modifyAppointment(final Long id, Appointment rdv){
        if (rdvDao.existsById(id)) {
            Appointment rdvTOModify = getAppointment(id).get();
            rdvTOModify.setClient(rdv.getClient());
            rdvTOModify.setProf(rdv.getProf());
            rdvTOModify.setCreneau(rdv.getCreneau());
            rdvTOModify.setTitle(rdv.getTitle());
            return rdvDao.save(rdvTOModify);
        }
        return rdv;
    }




}
