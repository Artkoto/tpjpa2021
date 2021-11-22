package fr.istic.taa.service;

import fr.istic.taa.repository.RdvRepository;
import lombok.Data;
import fr.istic.taa.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Data
public class RdvService {

    @Autowired
    private RdvRepository rdvRepository;

    public Optional<Rdv> getRdv(final Long id){
        return rdvRepository.findById(id);
    }

    public Iterable<Rdv> getRdvs()   {
        return rdvRepository.findAll();
    }
    public Iterable<Rdv> getRdvByTitle(String title)   {
        return rdvRepository.findByTitle(title);
    }
    public Iterable<Rdv> getRdvByUser(Long id)   {
        return rdvRepository.findByUser(id);
    }
    public Iterable<Rdv> getRdvByCrenel(Long id)   {
        return rdvRepository.findByCrenel(id);
    }

    public void  deleteRdv(final Long id){
        if (rdvRepository.existsById(id)) {
            rdvRepository.deleteById(id);
        }
    }

    public Rdv saveRdv(Rdv rdv){
        return rdvRepository.save(rdv);
    }
    public Rdv modifyRdv(final Long id, Rdv rdv){
        if (rdvRepository.existsById(id)) {
            Rdv rdvTOModify = getRdv(id).get();
            rdvTOModify.setTitle(rdv.getTitle());
            return rdvRepository.save(rdvTOModify);
        }
        return rdv;
    }




}
