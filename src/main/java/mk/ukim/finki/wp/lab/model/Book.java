package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String genre;
    private double averageRating;
    private Author author;


    private static Long idCounter = 0L;
    public Book(String title, String genre, double averageRating,Author author) {
        this.id = ++idCounter;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author=author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
