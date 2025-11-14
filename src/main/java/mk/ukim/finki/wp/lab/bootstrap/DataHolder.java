package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        Author a1 = new Author("Author1", "Author11", "Country1", "Biography of Author1");
        Author a2 = new Author("Author2", "Author22", "Country2", "Biography of Author2");
        Author a3 = new Author("Author3", "Author33", "Country3", "Biography of Author3");

        authors.add(a1);
        authors.add(a2);
        authors.add(a3);

        books.add(new Book("Book 1", "Classic", 4.5, a1));
        books.add(new Book("Book 2", "Fantasy", 4.8, a2));
        books.add(new Book("Book 3", "Romance", 4.6, a3));
        books.add(new Book("Book 4", "Adventure", 4.3, a1));
        books.add(new Book("Book 5", "Science Fiction", 4.9, a2));
        books.add(new Book("Book 6", "Thriller", 3.2, a3));
        books.add(new Book("Book 7", "Fantasy", 5.0, a1));
        books.add(new Book("Book 8", "Psychology", 4.1, a2));
        books.add(new Book("Book 9", "Comedy", 4.2, a3));
        books.add(new Book("Book 10", "Romance", 4.4, a1));
    }
}
