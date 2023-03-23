package mk.ukim.finki.emtlabs.web;

import mk.ukim.finki.emtlabs.model.Author;
import mk.ukim.finki.emtlabs.model.Book;
import mk.ukim.finki.emtlabs.model.Category;
import mk.ukim.finki.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emtlabs.service.AuthorService;
import mk.ukim.finki.emtlabs.service.BookService;
import mk.ukim.finki.emtlabs.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }
//Book book, String name, Category category, Author author);
        @PutMapping("/edit/{id}")
            public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto book2) {
                Book book = bookService.editBook(id,book2);
                if (book == null) {
                    return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            Book book2 = bookService.markBook(id);
            return ResponseEntity.ok(book2);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.removeBook(id);
            return ResponseEntity.ok(book);
        }
    }


}
