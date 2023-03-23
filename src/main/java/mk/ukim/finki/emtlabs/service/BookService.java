package mk.ukim.finki.emtlabs.service;

import mk.ukim.finki.emtlabs.model.Author;
import mk.ukim.finki.emtlabs.model.Book;
import mk.ukim.finki.emtlabs.model.Category;
import mk.ukim.finki.emtlabs.model.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> listAllBooks();
    public Book addBook(Book book);
    public Book getBookById(Long Id);
    public Book editBook(Long bookId, BookDto bookDto);
    public void removeBook(Long id);
    public Book markBook(Long id);

}
