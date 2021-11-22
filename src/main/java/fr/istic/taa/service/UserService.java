package fr.istic.taa.service;

import fr.istic.taa.repository.RdvRepository;
import fr.istic.taa.repository.UsersRepository;
import lombok.Data;
import fr.istic.taa.model.Rdv;
import fr.istic.taa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UserService {
    @Autowired
    private UsersRepository usersRepository ;
    @Autowired
    private RdvRepository rdvRepository;
    @Autowired
    private RdvService rdvService;

    public Optional<Users>getUser(final Long id){
        return usersRepository.findById(id);
    }
    public Optional<Users>getProf(final Long id){
        return usersRepository.findProfById(id);
    }
    public Optional<Users>getClient(final Long id){
        return usersRepository.findClientById(id);
    }
    public Optional<Users>getProfByRdv(final Long id){
        return usersRepository.findProfByRdv(id);
    }
    public Optional<Users>getClientByRdv(final Long id){
        return usersRepository.findClientByRdv(id);
    }
    public Optional<Users>getClientByEmail(final String email){
        return usersRepository.findClientByEmail(email);
    }
    public Optional<Users>getProfByEmail(final String email){
        return usersRepository.findProfByEmail(email);
    }
    public Iterable<Users> getUsersByCrenel(Long id)   {
        return usersRepository.findProfByCrenel(id);
    }
    public Iterable<Users> getUsers()   {
        return usersRepository.findAll();
    }
    public Iterable<Users> getProfs()   {
        return usersRepository.findAllProfs();
    }
    public Iterable<Users> getClients()   {
        return usersRepository.findAllClients();
    }
    public Iterable<Users> getUsersByName(String name)   {
        return usersRepository.findByName(name);
    }
    public Iterable<Users> getUsersByLastname(String lastname)   {
        return usersRepository.findByLastname(lastname);
    }
    public Optional<Users> getUsersByEmail(String email)   {
        return usersRepository.findByEmail(email);
    }


    public void  deleteUser(final Long id){
        if (usersRepository.existsById(id)) {
            for (Rdv rdv: rdvRepository.findByUser(id)) {
                rdvService.deleteRdv(rdv.getId());
            }
            usersRepository.deleteById(id);
        }
    }

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }
    public Users modifyUser(final Long id, Users user){
        if (usersRepository.existsById(id)) {
            Users userTOModify = getUser(id).get();
            userTOModify.setEmail(user.getEmail());
            userTOModify.setLastname(user.getLastname());
            userTOModify.setName(user.getName());
            return usersRepository.save(userTOModify);
        }
        return user;
    }


}
