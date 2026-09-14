package iuh.fit.se.bai4.servlet;

import iuh.fit.se.bai4.dao.BookDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword = req.getParameter("keyword");

        if (keyword != null && !keyword.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/books?keyword=" + URLEncoder.encode(keyword, "UTF-8"));
        } else {
            resp.sendRedirect(req.getContextPath() + "/books");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
