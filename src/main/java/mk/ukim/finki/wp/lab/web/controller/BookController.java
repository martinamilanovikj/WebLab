package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;


    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
@GetMapping
public String getBooksPage(@RequestParam(required = false) String error,
                           @RequestParam(required = false) String filterName,
                           @RequestParam(required = false) Double filterRating,
                           Model model) {
    List<Book> books = bookService.listAll();

    if (filterName != null && !filterName.isEmpty()) {
        books = books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(filterName.toLowerCase()))
                .toList();
    }

    if (filterRating != null) {
        books = books.stream()
                .filter(b -> b.getAverageRating() >= filterRating)
                .toList();
    }

    model.addAttribute("books", books);
    model.addAttribute("filterName", filterName);
    model.addAttribute("filterRating", filterRating);

    if (error != null) {
        model.addAttribute("error", error);
    }

    return "listBooks";
}

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        Author author = authorService.findById(authorId);
        Book newBook = new Book(title, genre, averageRating,author);
        bookService.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("book", null);
        return "book-form";
    }

    @GetMapping("/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "redirect:/books?error=BookNotFound";
        }

        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        Author author = authorService.findById(authorId);
        bookService.updateBook(bookId, title, genre, averageRating, author);

        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }


}
