package sample.repositories;

import sample.domain.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {


    public Iterable<User> findByName(String name);
    public Iterable<User> findByLastname(String lastName); 
    public Iterable<User> findByEmail(String email);

}
