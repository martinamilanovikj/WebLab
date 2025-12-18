package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    Book save(Book book);
    void updateBook(Long bookId, String title, String genre, Double averageRating, Author author);
    void deleteById(Long bookId);
    Book findById(Long id);
    List<Book> findAllByAuthor(Long authorId);
    Page<Book> find(String title, String genre, Double averageRating, Integer pageNum, Integer pageSize);

}
