package fr.istic.taa.controller;

import fr.istic.taa.service.RdvService;
import fr.istic.taa.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/rdv")
public class RdvController {
    @Autowired
    RdvService rdvService;

    /**
     * get appointment by ID
     * @param Id : id of the appointment
     * @return
     */
    @GetMapping("/id={Id}")
    public Optional<Rdv> getRdvById(@PathVariable("Id") Long Id)  {
        return rdvService.getRdv(Id);
    }

    @GetMapping("/user/id={userId}")
    public Iterable<Rdv> getRdvByUser(@PathVariable("userId") Long Id)  {
        return rdvService.getRdvByUser(Id);
    }

    @GetMapping("/creneau/id={crenelId}")
    public Iterable<Rdv> getRdvByCrenel(@PathVariable("crenelId") Long Id)  {
        return rdvService.getRdvByCrenel(Id);
    }
    /**
     * get all appointments
     * @return
     */
    @GetMapping("/all")
    public Iterable<Rdv> getAllRdvs() {
        return rdvService.getRdvs();
    }

    /**
     *  get appointment by title
     * @param title : title of the appointment
     * @return
     */
    @GetMapping("/title={title}")
    public Iterable<Rdv> getRdvByTitle(@PathVariable("title") String title)  {
        return rdvService.getRdvByTitle(title);
    }

    /**
     *  add appointment
     * @param rdv : appointment
     * @return
     */
    @PostMapping("/add")
    public Rdv addRdv(Rdv rdv) {
        return rdvService.saveRdv(rdv);

    }

    /**
     *  modify an appointment
     * @param id
     * @param rdv
     * @return
     */
    @PutMapping("/{rdvId}/update")
    public Rdv modifyRdv( @PathVariable("rdvId") Long id, Rdv rdv) {
        return rdvService.modifyRdv(id, rdv);
    }

    /***
     *  delete appointment
     * @param rdvId : id of the appointment
     * @return
     */
    @DeleteMapping("/{Id}/delete")
    public void deleteRdv(@PathVariable("Id") Long rdvId) {
         rdvService.deleteRdv(rdvId);
    }
}
