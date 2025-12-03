//package mk.ukim.finki.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.BookReservation;
//import mk.ukim.finki.wp.lab.service.BookReservationService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "BookReservationServlet", urlPatterns = "/bookReservation")
//public class BookReservationServlet extends HttpServlet {
//
//    private final SpringTemplateEngine templateEngine;
//    private final BookReservationService bookReservationService;
//
//    public BookReservationServlet(SpringTemplateEngine templateEngine,
//                                  BookReservationService bookReservationService) {
//        this.templateEngine = templateEngine;
//        this.bookReservationService = bookReservationService;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//
//        String bookTitle = request.getParameter("bookTitle");
//        String readerName = request.getParameter("readerName");
//        String readerAddress = request.getParameter("readerAddress");
////        int numCopies = Integer.parseInt(request.getParameter("numCopies"));
//        String numCopiesParam = request.getParameter("numCopies");
//        int numCopies = 0;
//
//        if (numCopiesParam != null) {
//            numCopies = Integer.parseInt(numCopiesParam);
//        }
//
//
//
//        String clientIp = request.getRemoteAddr();
//
//        BookReservation reservation = bookReservationService
//                .placeReservation(bookTitle, readerName, readerAddress, numCopies);
//
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(request, response);
//
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("reservation", reservation);
//        context.setVariable("clientIp", clientIp);
//
//
//        templateEngine.process("reservationConfirmation.html", context, response.getWriter());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(request, response);
//
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("message", "Please make a reservation first.");
//
//        templateEngine.process("reservationConfirmation.html", context, response.getWriter());
//    }
//}
