package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.model.Gender;
import mk.ukim.finki.wp.lab.repository.jpa.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (!authorRepository.findAll().isEmpty() || !bookRepository.findAll().isEmpty()) {
            return;
        }

        Author a1 = new Author("Author1", "Author11", "Country1", "Biography of Author1", Gender.MALE);
        Author a2 = new Author("Author2", "Author22", "Country2", "Biography of Author2", Gender.FEMALE);
        Author a3 = new Author("Author3", "Author33", "Country3", "Biography of Author3", Gender.FEMALE);

        authors.add(a1);
        authors.add(a2);
        authors.add(a3);

        authorRepository.saveAll(authors);

        Book b1 = new Book("Book 1", "Classic", 4.5, a1);
        Book b2 = new Book("Book 2", "Fantasy", 4.8, a2);
        Book b3 = new Book("Book 3", "Romance", 4.6, a3);
        Book b4 = new Book("Book 4", "Adventure", 4.3, a1);
        Book b5 = new Book("Book 5", "Science Fiction", 4.9, a2);
        Book b6 = new Book("Book 6", "Thriller", 3.2, a3);
        Book b7 = new Book("Book 7", "Fantasy", 5.0, a1);
        Book b8 = new Book("Book 8", "Psychology", 4.1, a2);
        Book b9 = new Book("Book 9", "Comedy", 4.2, a3);
        Book b10 = new Book("Book 10", "Romance", 4.4, a1);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        bookRepository.saveAll(books);

        reservations = new ArrayList<>();
    }
}


