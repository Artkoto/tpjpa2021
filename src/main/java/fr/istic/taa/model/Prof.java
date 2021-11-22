package fr.istic.taa.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Prof extends Users {
    @ManyToMany
    @JoinTable(name = "User_Creneau")
    @JsonIgnore
    private Set<Creneau> creneaux;

    @OneToMany(mappedBy = "prof")
    @JsonIgnore
    private Set<Rdv> rdv;
}
