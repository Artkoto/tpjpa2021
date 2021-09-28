package sample.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Appointment")
@Data
public class Appointment implements Serializable {
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
