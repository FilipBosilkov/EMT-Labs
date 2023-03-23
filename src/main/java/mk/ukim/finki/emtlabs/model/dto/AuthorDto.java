package mk.ukim.finki.emtlabs.model.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AuthorDto {
    private String name;
    private String surname;
    private Long country;
}
