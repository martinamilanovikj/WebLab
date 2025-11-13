package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", urlPatterns = "")
public class BookListServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;
    private final BookService bookService;

    public BookListServlet(SpringTemplateEngine templateEngine, BookService bookService) {
        this.templateEngine = templateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);

        String filterName = request.getParameter("filterName");
        String filterRatingParam = request.getParameter("filterRating");

        List<Book> books;

        if (((filterName != null) && !filterName.isEmpty()) || (filterRatingParam != null && !filterRatingParam.isEmpty())) {
            double filterRating = 0;
            try {
                filterRating = Double.parseDouble(filterRatingParam);
            } catch (Exception ignored) {}


            books = bookService.searchBooks(filterName, filterRating);
        } else {
            books = bookService.listAll();
        }

        WebContext context = new WebContext(webExchange);
        context.setVariable("books", books);

        templateEngine.process("listBooks", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selectedBook = request.getParameter("bookTitle");
        String numCopies = request.getParameter("numCopies");

        request.getSession().setAttribute("selectedBook", selectedBook);
        request.getSession().setAttribute("numCopies", numCopies);

        response.sendRedirect("/bookDetails");
    }
}
