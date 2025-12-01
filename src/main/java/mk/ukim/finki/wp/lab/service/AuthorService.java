package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.Gender;

import java.util.List;

public interface AuthorService {
    public List<Author> findAll();
    Author addAuthor(Author author);
    void updateAuthor(Long authorId, String name, String surname, String country, String biography, Gender gender);
    void deleteAuthor(Long authorId);
    Author findById(Long id);
}
