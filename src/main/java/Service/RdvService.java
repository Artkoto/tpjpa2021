package Service;

import dao.RdvDao;
import lombok.Data;
import model.Rdv;

import java.util.Optional;
@Data
public class RdvService {

    private RdvDao rdvDao = new RdvDao();

    public Optional<Rdv> getRdv(final Long id){
        return rdvDao.findOne(id);
    }

    public Iterable<Rdv> getRdvs()   {
        return rdvDao.findAll();
    }
    public Iterable<Rdv> getRdvByTitle(String title)   {
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
            return rdvDao.update(rdvTOModify);
        }
        return rdv;
    }




}
