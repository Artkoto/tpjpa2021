package fr.istic.taa.controller;

import fr.istic.taa.model.Client;
import fr.istic.taa.service.UserService;

import fr.istic.taa.model.Prof;
import fr.istic.taa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @GetMapping(value = "/id={Id}")
    public Optional<Users> getPetById(@PathVariable("Id") Long userId)  {
            return userService.getUser(userId);
        }

    @GetMapping("/email={userEmail}")
    public Optional<Users> getUserByEmail(@PathVariable("userEmail") String userEmail)  {
        return userService.getUsersByEmail(userEmail);
    }
    @GetMapping("/client/id={Id}")
    public Optional<Users> getClientById(@PathVariable("Id") Long id)  {
        return userService.getClient(id);
    }
    @GetMapping("/client/email={email}")
    public Optional<Users> getClientByEmail(@PathVariable("email") String email)  {
        return userService.getClientByEmail(email);
    }
    @GetMapping("client/rdv/id={rdvId}/")
    public Optional<Users> getClientByRdv(@PathVariable("rdvId") Long id)  {
        return userService.getClientByRdv(id);
    }
    @GetMapping("/prof/id={Id}")
    public Optional<Users> getProfById(@PathVariable("Id") Long id)  {
        return userService.getProf(id);
    }

    @GetMapping("/prof/email={email}")
    public Optional<Users> getprofByEmail(@PathVariable("email") String email)  {
        return userService.getProfByEmail(email);
    }
    @GetMapping("/prof/rdv/id={rdvId}")
    public Optional<Users> getprofByRdv(@PathVariable("rdvId") Long id)  {
        return userService.getProfByRdv(id);
    }

    @GetMapping("/firstname={userName}")
    public Iterable<Users> getUserByName(@PathVariable("userName") String userName)  {
        return userService.getUsersByName(userName);
    }

    @GetMapping("/lastname={userLastname}")
    public Iterable<Users> getUserByLastname(@PathVariable("userLastname") String userLastname){
        return userService.getUsersByLastname(userLastname);
    }

    @GetMapping("/creneau/id={Id}")
    public Iterable<Users> getAllUsersByCrenel(@PathVariable("Id") Long id)  {
        return userService.getUsersByCrenel(id);
    }

    @GetMapping("/all")
    public Iterable<Users> getAllUsers()  {
        return userService.getUsers();
    }


    @GetMapping("/profs")
    public Iterable<Users> getAllProfs()  {
        return userService.getProfs();
    }

    @GetMapping("/clients")
    public Iterable<Users> getClients()  {
        return userService.getClients();
    }

    @PostMapping("/client/add")
    public Users addClient(Client user) {
        return userService.saveUser(user);
    }
    @PostMapping("/prof/add")
    public Users addProf(Prof user) {
        return userService.saveUser(user);
    }

    /**
     *  modify a user
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/prof/{userId}/update")
    public Users modifyProf(@PathVariable("userId") Long id, Prof  user) {
        return userService.modifyUser(id, user);
    }

    @PutMapping("/client/{userId}/update")
    public Users modifyClient(@PathVariable("userId") Long id, Client user) {
        return userService.modifyUser(id, user);
    }



    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable("userId") Long userId)  {
        userService.deleteUser(userId);
    }
}
