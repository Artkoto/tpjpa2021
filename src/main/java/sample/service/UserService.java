package sample.service;

import sample.dao.*;
import sample.domain.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class UserService {

    @Autowired
    private UserDao  usersDao ;

    @Autowired
    private RdvDao rdvDao ;
    
    @Autowired
    private RdvService rdvService;

    public Optional<User>getUser(final Long  id){
        return usersDao.findById(id);
    }

    public Iterable<User> getUsers()   {
            return usersDao.findAll();
    }

    public Iterable<User> getUsersByName(String name)   {
        return usersDao.findByName(name);
    }
    public Iterable<User> getUsersByLastname(String lastname)   {
        return usersDao.findByLastname(lastname);
    }
    public Iterable<User> getUsersByEmail(String email)   {
        return usersDao.findByEmail(email);
    }

    public void  deleteUser(final Long id){
            usersDao.deleteById(id);
    }

    public User saveUser(User user) {
        return usersDao.save(user);
    }

    public User updateUser(User user){
        return usersDao.save(user);
    }
}
