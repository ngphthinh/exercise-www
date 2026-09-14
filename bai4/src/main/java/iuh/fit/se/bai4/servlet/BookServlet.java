package iuh.fit.se.bai4.servlet;

import iuh.fit.se.bai4.dao.BookDAO;
import iuh.fit.se.bai4.model.Book;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/books", "/book"})
public class BookServlet extends HttpServlet {

    @Resource(name = "jdbc/storedb")
    private DataSource dataSource;
    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String id = req.getParameter("id");
        if (id != null) {
            req.setAttribute("book", bookDAO.getBookById(id));
            req.getRequestDispatcher("/book-detail.jsp").forward(req, resp);
            return;

        }
        List<Book> list;
        // Kiểm tra nếu có keyword thì tìm kiếm, không thì lấy tất cả
        if (keyword != null && !keyword.trim().isEmpty()) {
            list = bookDAO.searchBooks(keyword);
            req.setAttribute("keyword", keyword); // Gửi lại keyword ra JSP để hiển thị ô tìm kiếm
        } else {
            list = bookDAO.getAllBooks();
        }

        req.setAttribute("books", list);
        req.getRequestDispatcher("/books.jsp").forward(req, resp);

    }
}
