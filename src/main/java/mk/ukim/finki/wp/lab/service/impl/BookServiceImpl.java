package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return this.bookRepository.searchBooks(text,rating);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public void updateBook(Long bookId, String title, String genre, Double averageRating, Author author) {
        Book book = bookRepository.findById(bookId);
        if (book != null) {
            book.setTitle(title);
            book.setGenre(genre);
            book.setAverageRating(averageRating);
            book.setAuthor(author);
        }
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }


}
