package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Gender;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public String getAuthorsPage(@RequestParam(required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("error", error);
        }
        model.addAttribute("authors", authorService.findAll());
        return "listAuthors";
    }

    @PostMapping("/add")
    public String saveAuthor(@RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String country,
                           @RequestParam String biography,
                           @RequestParam Gender gender) {

        Author newAuthor = new Author(name, surname, country, biography,gender);
        authorService.save(newAuthor);

        return "redirect:/authors";
    }

    @GetMapping("/author-form")
    public String getAddAuthorPage(Model model) {
        model.addAttribute("author", null);
        return "author-form";
    }

    @GetMapping("/author-form/{id}")
    public String getEditAuthorForm(@PathVariable Long id, Model model) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "redirect:/authors?error=AuthorNotFound";
        }

        model.addAttribute("author", author);
        return "author-form";
    }

    @PostMapping("/edit/{authorId}")
    public String editAuthor(@PathVariable Long authorId,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String country,
                           @RequestParam String biography,
                           @RequestParam Gender gender) {

        authorService.updateAuthor(authorId, name, surname, country, biography,gender);
        return "redirect:/authors";
    }

    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }


}
