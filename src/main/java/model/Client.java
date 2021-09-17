package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.EqualsExclude;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("Client")
@Data
public class Client extends Users {
    @OneToMany(mappedBy = "client")
    @EqualsAndHashCode.Exclude
    private Set<Rdv> rdv = new HashSet<>();
}
