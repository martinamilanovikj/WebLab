package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Author {
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;
    private Gender gender;

    private static Long idCounter = 0L;
    public Author(String name, String surname, String country, String biography,Gender gender) {
        this.id = ++idCounter;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
