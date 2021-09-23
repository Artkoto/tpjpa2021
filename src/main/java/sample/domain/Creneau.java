package sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "creneau")
@Data
public class Creneau {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date debut;
    @Temporal(TemporalType.DATE)
    private Date fin ;

    @ManyToMany(mappedBy = "creneaux", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JsonIgnore
    private Set<Prof> profs = new HashSet<>();

    @OneToMany( mappedBy = "creneau", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<Rdv> rdv = new HashSet<>();


}
