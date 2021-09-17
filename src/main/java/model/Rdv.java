package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Rdv implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JsonIgnore
    Client client;

    @ManyToOne
    @JsonIgnore
    Prof prof;
    @ManyToOne
    @JsonIgnore
    Creneau creneau;

}
