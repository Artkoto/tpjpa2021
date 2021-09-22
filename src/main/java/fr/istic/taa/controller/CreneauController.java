package fr.istic.taa.controller;

import fr.istic.taa.model.Creneau;
import fr.istic.taa.service.CreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/slot")
public class CreneauController {
    @Autowired
    CreneauService creneauService;

    /**
     *  get crenel by Id
     * @param creneauId
     * @return
     */
    @GetMapping("/id={Id}")
    public Optional<Creneau> getCreneau(@PathVariable("Id") Long creneauId) {
        return creneauService.getCreneau(creneauId);
    }

    @GetMapping("/rdv/id={Id}")
    public Optional<Creneau> getByRdv(@PathVariable("Id") Long Id) {
        return creneauService.getByRdv(Id);
    }

    @GetMapping("/user/id={Id}")
    public Iterable<Creneau> getByUser(@PathVariable("Id") Long Id) {
        return creneauService.getByUser(Id);
    }
    /**
     * get all slots
     * @return
     */

    @GetMapping("/all")
    public Iterable<Creneau> getAllCreneaux() {
        return creneauService.getCreneaux();
    }

    @PostMapping("/add")
    public Creneau addCreneau( Creneau creneau)  {
        return creneauService.saveCreneau(creneau);
    }

    @PutMapping("/{creneauId}/update")
    public Creneau modifyCreneau(@PathVariable("creneauId") Long id, Creneau creneau) {
        return creneauService.modifyCreneau(id, creneau);
    }

}
