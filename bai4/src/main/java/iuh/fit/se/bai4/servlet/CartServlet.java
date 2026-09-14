package iuh.fit.se.bai4.servlet;

import iuh.fit.se.bai4.dao.BookDAO;
import iuh.fit.se.bai4.model.Book;
import iuh.fit.se.bai4.model.Cart;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet({"/cart", "/cart/*"})
public class CartServlet extends HttpServlet {


    @Resource(name = "jdbc/storedb")
    private DataSource dataSource;
    private BookDAO bookDAO;


    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            cart.addItem(bookDAO.getBookById("1"));
            cart.addItem(bookDAO.getBookById("1"));
            cart.addItem(bookDAO.getBookById("1"));
            cart.addItem(bookDAO.getBookById("2"));
            cart.addItem(bookDAO.getBookById("3"));
            httpSession.setAttribute("cart", cart);
        }

        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String bookId = req.getParameter("bookId");

        HttpSession httpSession = req.getSession();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();

            httpSession.setAttribute("cart", cart);
        }

        switch (action) {
            case "add":
                Book book = bookDAO.getBookById(bookId);
                if (book != null) {
                    cart.addItem(book);
                }

                break;
            case "remove":
                cart.removeItem(bookId);
                break;
            default:
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}
