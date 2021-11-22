package fr.istic.taa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends Users {

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Rdv> rdv;
}
