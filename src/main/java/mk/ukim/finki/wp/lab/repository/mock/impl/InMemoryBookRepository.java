package mk.ukim.finki.wp.lab.repository.mock.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.mock.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepository implements BookRepository {

        @Override
        public List<Book> findAll () {
            return DataHolder.books;
        }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(text.toLowerCase())
                        && book.getAverageRating() >= rating)
                .collect(Collectors.toList());
    }

    @Override
    public Book add(Book book) {
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Book book = findById(id);
        if (book != null) {
            DataHolder.books.remove(book);
        }
    }
}
