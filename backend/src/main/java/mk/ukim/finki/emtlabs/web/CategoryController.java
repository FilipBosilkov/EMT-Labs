package mk.ukim.finki.emtlabs.web;

import mk.ukim.finki.emtlabs.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"categories"})
public class CategoryController {

    @GetMapping
    public List<Category> findAll() {
        return Arrays.asList(Category.values().clone());
    }
}
