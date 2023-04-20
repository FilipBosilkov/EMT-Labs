package mk.ukim.finki.emtlabs.model.dto;

import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.emtlabs.model.Category;

@Data
@Getter
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;
}
