package sample.dao;

import sample.domain.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {


    public User findByName(String name);
    public User findByLastname(String lastName); 
    public User findByEmail(String email);

}
