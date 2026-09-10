package iuh.fit.se.de01.servlet;

import iuh.fit.se.de01.util.Repository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/course")
public class ListServlet extends HttpServlet {

    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("courses", repository.getCourses());
        req.getRequestDispatcher("/course-list.jsp").forward(req, resp);
    }


}
