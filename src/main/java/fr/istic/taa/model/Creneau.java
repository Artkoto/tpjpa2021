package fr.istic.taa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Creneau implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date debut;
    @Temporal(TemporalType.DATE)
    private Date fin ;

    @ManyToMany(mappedBy = "creneaux")
    @JsonIgnore
    private Set<Prof> profs;

    @OneToMany( mappedBy = "creneau",fetch= FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<Rdv> rdv ;
}
