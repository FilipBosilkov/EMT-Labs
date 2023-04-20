package mk.ukim.finki.emtlabs.service.impl;

import mk.ukim.finki.emtlabs.model.Book;
import mk.ukim.finki.emtlabs.model.dto.BookDto;
import mk.ukim.finki.emtlabs.repository.AuthorRepository;
import mk.ukim.finki.emtlabs.repository.BookRepository;
import mk.ukim.finki.emtlabs.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(BookDto book1){
        Random random = new Random();
        Book book = new Book();
        book.setId(random.nextLong(0,10000));
        book.setAuthor(authorRepository.findById(book1.getAuthor()).orElse(null));
        book.setName(book1.getName());
        book.setAvailableCopies(book1.getAvailableCopies());
        book.setCategory(book1.getCategory());
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long Id) {
        return bookRepository.findById(Id).orElse(null);
    }

    @Override
    public Book editBook(Long book, BookDto bookDto) {
        Book book1 = bookRepository.findById(book).orElse(null);
        if (book1!=null) {
            book1.setName(bookDto.getName());
            book1.setCategory(bookDto.getCategory());
            book1.setAuthor(authorRepository.findById(bookDto.getAuthor()).orElse(null));
            book1.setAvailableCopies(bookDto.getAvailableCopies());
            return bookRepository.save(book1);
        }
        return null;
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book markBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book!=null)
        {
            book.setAvailableCopies(book.getAvailableCopies()-1);
            return bookRepository.save(book);
        }
        return null;

    }


}
