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

@WebServlet("/course/edit/*")
public class EditServlet extends HttpServlet {

    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        String id = path.split("/")[1];
        System.out.println(id);

        Course course = repository.getCourses().stream().filter(e -> e.getId() == Integer.parseInt(id)).findFirst().orElse(null);

        req.setAttribute("course", course);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        String id = path.split("/")[1];
        System.out.println(id);
        String courseName = req.getParameter("courseName");
        String instructor = req.getParameter("instructor");
        String category = req.getParameter("category");
        String level = req.getParameter("level");
        double price = Double.parseDouble(req.getParameter("price"));
        int duration = Integer.parseInt(req.getParameter("duration"));
        String startDate = req.getParameter("startDate");
        boolean featured = Boolean.parseBoolean(req.getParameter("featured"));


        Course course = Course.builder()
                .id(Integer.parseInt(id))
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
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
            return;
        }

        List<Course> courses = repository.getCourses();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == Integer.parseInt(id)) {
                courses.set(i, course);
                break;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/course");
    }
}
