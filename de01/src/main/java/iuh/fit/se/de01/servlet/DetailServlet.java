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

@WebServlet("/course/*")
public class DetailServlet extends HttpServlet {
    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String id = path.substring(1);

        Course course = repository.getCourses().stream().filter(e -> e.getId() == Integer.parseInt(id)).findFirst().orElse(null);
        if (course == null) {
            req.setAttribute("message", "Not found");
        } else {
            req.setAttribute("course", course);
        }

        req.getRequestDispatcher("/detail.jsp").forward(req, resp);
    }
}
