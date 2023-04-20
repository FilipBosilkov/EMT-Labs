package mk.ukim.finki.emtlabs.model.dto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CountryDto {
    private String name;
    private String continent;
}
