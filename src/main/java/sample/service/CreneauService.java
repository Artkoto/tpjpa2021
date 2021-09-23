package sample.service;

import sample.domain.*;
import sample.repositories.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
@Service
@Data
public class CreneauService {

    @Autowired
    private CreneauDao creneauDao;
    @Autowired
    private RdvDao rdvDao;
    @Autowired
    private RdvService rdvService;

    public Optional<Creneau> getCreneau(final Long id){
        return creneauDao.findById(id);
    }

    public Iterable<Creneau> getCreneaux()   {
        return creneauDao.findAll();
    }
    
    public void  deleteCreneau(final Long id){
        if (creneauDao.existsById(id)) {

            for (Rdv rdv : rdvDao.getRdvsByCreneauId(id)){
                rdvService.deleteRdv(rdv.getId());
            }
            creneauDao.deleteById(id);
        }
    }

    public Creneau saveCreneau(Creneau creneau){
        return creneauDao.save(creneau);
    }
    
    public Creneau modifyCreneau(final Long id, Creneau creneau){
        if (creneauDao.existsById(id)) {
            Creneau creneauTOModify = getCreneau(id).get();
            creneauTOModify.setDebut(creneau.getDebut());
            creneauTOModify.setFin(creneau.getFin());
            creneauTOModify.setProfs(creneau.getProfs());
            creneauTOModify.setRdv(creneau.getRdv());
            return creneauDao.save(creneauTOModify);
        }
        return creneau;
    }    
}
