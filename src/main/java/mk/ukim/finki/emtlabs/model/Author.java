package mk.ukim.finki.emtlabs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Author {
    @Id
    private Long Id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(Long id, String name, String surname, Country country) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    public Author()
    {}



}
