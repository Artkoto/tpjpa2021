package fr.istic.taa.service;

import fr.istic.taa.repository.CreneauRepository;
import fr.istic.taa.repository.RdvRepository;
import lombok.Data;
import fr.istic.taa.model.Creneau;
import fr.istic.taa.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CreneauService {
    @Autowired
    private CreneauRepository creneauRepository;
    @Autowired
    private RdvRepository rdvRepository;
    @Autowired
    private RdvService rdvService;

    public Optional<Creneau> getCreneau(final Long id){
        return creneauRepository.findById(id);
    }
    public Optional<Creneau> getByRdv(final Long id){
        return creneauRepository.findByRdv(id);
    }
    public Iterable<Creneau> getByUser(final Long id){
        return creneauRepository.findByUser(id);
    }

    public Iterable<Creneau> getCreneaux()   {
        return creneauRepository.findAll();
    }
    
    public void  deleteCreneau(final Long id){
        if (creneauRepository.existsById(id)) {
            for (Rdv rdv : rdvRepository.findByCrenel(id)){
                rdvService.deleteRdv(rdv.getId());
            }
            creneauRepository.deleteById(id);
        }
    }

    public Creneau saveCreneau(Creneau creneau){
        return creneauRepository.save(creneau);
    }
    public Creneau modifyCreneau(final Long id, Creneau creneau){
        if (creneauRepository.existsById(id)) {
            Creneau creneauTOModify = getCreneau(id).get();
            creneauTOModify.setDebut(creneau.getDebut());
            creneauTOModify.setFin(creneau.getFin());
            return creneauRepository.save(creneauTOModify);
        }
        return creneau;
    }    
}
