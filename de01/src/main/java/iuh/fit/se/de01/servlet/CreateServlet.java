package iuh.fit.se.de01.servlet;

import iuh.fit.se.de01.model.Course;
import iuh.fit.se.de01.util.Repository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        String instructor = req.getParameter("instructor");
        String category = req.getParameter("category");
        String level = req.getParameter("level");
        double price = Double.parseDouble(req.getParameter("price"));
        int duration = Integer.parseInt(req.getParameter("duration"));
        String startDate = req.getParameter("startDate");
        boolean featured = Boolean.parseBoolean(req.getParameter("featured"));

        Course course = Course.builder()
                .courseName(courseName)
                .instructor(instructor)
                .category(category)
                .level(level)
                .price(price)
                .duration(duration)
                .startDate(startDate)
                .featured(featured)
                .build();

        if (courseName.isEmpty()) {
            req.setAttribute("error", "Error");
            req.setAttribute("course", course);
            req.getRequestDispatcher("/create.jsp").forward(req, resp);
            return;
        }

        repository.getCourses().add(course);
        resp.sendRedirect(req.getContextPath() + "/course");

    }
}
