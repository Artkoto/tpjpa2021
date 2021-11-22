package fr.istic.taa.repository;

import fr.istic.taa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT e FROM Prof  as e")
    List<Users> findAllProfs() ;

    @Query("SELECT e FROM Client as e")
    List<Users> findAllClients();

    @Query("select e from Client as e where e.id=?1  ")
    Optional<Users> findClientById(Long id);
    @Query("select e from Prof as e where e.id=?1  ")
    Optional<Users> findProfById(Long id);

    @Query("select e.client from Rdv as e where e.id=?1  ")
    Optional<Users> findClientByRdv(Long rdvId);

    @Query("select e.prof from Rdv as e where e.id=?1 ")
    Optional<Users> findProfByRdv(Long rdvId);

    @Query("select e.profs from Creneau as e where e.id=?1 ")
    List<Users> findProfByCrenel(Long crenelId);

    List<Users> findByName(String txt);
    List<Users> findByLastname(String txt);
    Optional<Users> findByEmail(String txt);

    @Query("select e from Client as e where e.email=?1  ")
    Optional<Users> findClientByEmail(String txt);
    @Query("select e from Prof as e where e.email=?1  ")
    Optional<Users> findProfByEmail(String txt);


}
