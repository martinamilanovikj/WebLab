package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Gender;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author save(Author author);
    void deleteById(Long id);
    void updateAuthor(Long authorId, String name, String surname, String country, String biography, Gender gender);
}
