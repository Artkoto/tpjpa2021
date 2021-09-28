package sample.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@DiscriminatorValue("Prof")
@Table(name = "users")
@Data
public class Prof extends User {
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "User_Creneau")
    @JsonIgnore
    private Set<Creneau> creneaux  = new HashSet<>();

    @OneToMany(mappedBy = "prof", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE})
    @JsonIgnore
    private Set<Appointment> rdv  = new HashSet<>();;
}
