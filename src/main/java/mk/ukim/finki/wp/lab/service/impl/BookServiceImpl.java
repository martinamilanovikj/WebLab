package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static mk.ukim.finki.wp.lab.service.FieldFilterSpecification.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
@Override
public List<Book> listAll() {
    return bookRepository.findAll();
}

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, String title, String genre, Double averageRating, Author author) {
        Book book = findById(bookId);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Page<Book> find(String title, String genre, Double averageRating, Integer pageNum, Integer pageSize) {
        Specification<Book> specification = Specification.allOf(
                filterContainsText(Book.class, "title", title),
                filterEqualsV(Book.class, "genre", genre),
                greaterThan(Book.class, "averageRating", averageRating)
        );
        return this.bookRepository.findAll(
                specification,
                PageRequest.of(pageNum, pageSize));
    }



    @Override
    public List<Book> findAllByAuthor(Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

}
