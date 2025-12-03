package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
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
    public List<Book> findAllByAuthor(Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

}
