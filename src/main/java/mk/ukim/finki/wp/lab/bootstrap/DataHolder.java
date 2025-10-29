package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("Book 1", "Classic", 4.5));
        books.add(new Book("Book 2", "Classic", 4.8));
        books.add(new Book("Book 3", "Dystopian", 4.7));
        books.add(new Book("Book 4", "Romance", 4.6));
        books.add(new Book("Book 5", "Fantasy", 4.9));
        books.add(new Book("Book 6", "Adventure", 4.1));
        books.add(new Book("Book 7", "Fantasy", 4.9));
        books.add(new Book("Book 8", "Classic", 4.0));
        books.add(new Book("Book 9", "Science Fiction", 4.3));
        books.add(new Book("Book 10", "Fantasy", 5.0));
    }
}
