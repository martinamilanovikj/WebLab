package mk.ukim.finki.wp.lab.repository.mock;
import mk.ukim.finki.wp.lab.model.Author;
import java.util.List;

public interface AuthorRepository {

    public List<Author> findAll();
    Author findById(Long id);
    Author add(Author author);
    void delete(Long id);
}
