package mk.ukim.finki.emtlabs.components;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emtlabs.model.Author;
import mk.ukim.finki.emtlabs.model.Book;
import mk.ukim.finki.emtlabs.model.Category;
import mk.ukim.finki.emtlabs.model.Country;
import mk.ukim.finki.emtlabs.repository.AuthorRepository;
import mk.ukim.finki.emtlabs.repository.BookRepository;
import mk.ukim.finki.emtlabs.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i < 31; i++)
            start(i);
    }

    private void start(int i) {
        Random random = new Random();
        Country country = new Country();
        country.setName(String.format("Country %d", i));
        country.setContinent(String.format("Continent %d", i));
        country.setId(random.nextLong(0,10000));
        countryRepository.save(country);
        Author author = new Author();
        author.setName(String.format("Author %d", i));
        author.setSurname(String.format("AuthorSurname %d", i));
        author.setCountry(country);
        author.setId(random.nextLong(0,10000));
        authorRepository.save(author);
        Book book = new Book();
        book.setName(String.format("Book %d", i));
        book.setCategory(Category.values()[i % Category.values().length]);
        book.setAuthor(author);
        book.setAvailableCopies(random.nextInt(0,100));
        book.setId(random.nextLong(0,10000));
        bookRepository.save(book);
    }
}
