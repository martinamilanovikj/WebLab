package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {

    private final BookService bookService;
    private final BookReservationService reservationService;

    public BookReservationController(BookService bookService, BookReservationService reservationService) {
        this.bookService = bookService;
        this.reservationService = reservationService;
    }

    @PostMapping
    public String reserveBook(HttpServletRequest request, Model model,
                              @RequestParam("book") Long selectedBookId,
                              @RequestParam("readerName") String readerName,
                              @RequestParam("readerAddress") String readerAddress,
                              @RequestParam("numCopies") int numCopies) {

        Book selectedBook = bookService.findById(selectedBookId);

        BookReservation reservation = reservationService.placeReservation(
                selectedBook.getTitle(),
                readerName,
                readerAddress,
                numCopies
        );

        model.addAttribute("reservation", reservation); // важно за Thymeleaf
        model.addAttribute("ipAddress", request.getRemoteAddr());

        return "reservationConfirmation";
    }

}
