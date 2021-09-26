package sample.domain;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Client")
@Table(name = "users")
@Data
public class Client extends User {
    
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Rdv> rdv = new HashSet<>();

    public Set<Rdv> getRdv() {
        return rdv;
    }

    public void setRdv(Set<Rdv> rdv) {
        this.rdv = rdv;
    }
}