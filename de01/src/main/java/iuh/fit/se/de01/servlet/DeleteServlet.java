package iuh.fit.se.de01.servlet;

import iuh.fit.se.de01.util.Repository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete/*")
public class DeleteServlet extends HttpServlet {
    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        int id = Integer.parseInt(path.substring(1));

        repository.getCourses().removeIf(e -> e.getId() == id);
        resp.sendRedirect(req.getContextPath() + "/course");
    }

}
