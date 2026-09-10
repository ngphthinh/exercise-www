package iuh.fit.se.de01.servlet;

import iuh.fit.se.de01.model.Course;
import iuh.fit.se.de01.util.Repository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        List<Course> courseList = repository.getCourses().stream().filter(e -> e.getCourseName().contains(search)).toList();
        req.setAttribute("search", search);
        req.setAttribute("courses", courseList);
        req.getRequestDispatcher("/course-list.jsp").forward(req, resp);


    }
}
