package sample.service;


import lombok.Data;
import sample.domain.Rdv;
import sample.repositories.RdvDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Data
public class RdvService {

    @Autowired
    private RdvDao rdvDao; 

    public Optional<Rdv> getRdv(final Long id){
        return rdvDao.findById(id);
    }

    public Iterable<Rdv> getRdvs()   {
        return rdvDao.findAll();
    }
    public Rdv getRdvByTitle(String title)   {
        return rdvDao.findByTitle(title);
    }

    public Rdv getByTitle(String title)   {
        return rdvDao.findByTitle(title);
    }

    public void  deleteRdv(final Long id){
        if (rdvDao.existsById(id)) {
            rdvDao.deleteById(id);
        }
    }

    public Rdv saveRdv(Rdv rdv){
        return rdvDao.save(rdv);
    }
    public Rdv modifyRdv(final Long id, Rdv rdv){
        if (rdvDao.existsById(id)) {
            Rdv rdvTOModify = getRdv(id).get();
            rdvTOModify.setClient(rdv.getClient());
            rdvTOModify.setProf(rdv.getProf());
            rdvTOModify.setCreneau(rdv.getCreneau());
            rdvTOModify.setTitle(rdv.getTitle());
            return rdvDao.save(rdvTOModify);
        }
        return rdv;
    }




}
