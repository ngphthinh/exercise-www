package iuh.fit.se.de01.servlet;

import iuh.fit.se.de01.model.User;
import iuh.fit.se.de01.util.Repository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private Repository repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = repository.getUsers().stream().filter(e ->
                e.getUsername().equals(username)).findFirst().orElse(null);
        if (user == null) {
            req.setAttribute("error", "Invalid username");
            req.setAttribute("username", username);
            req.setAttribute("password", password);

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if (!user.getPassword().equals(password)) {
            req.setAttribute("error", "Invalid password");
            req.setAttribute("password", password);
            req.setAttribute("username", username);

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/course");
    }
}
