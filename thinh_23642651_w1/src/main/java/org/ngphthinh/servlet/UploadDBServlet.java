package org.ngphthinh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.ngphthinh.config.DatabaseUtil;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/uploadDb")
@MultipartConfig
public class UploadDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/upload-db.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Part part = req.getPart("portraitPhoto");
        String fileName = part.getSubmittedFileName();
        resp.setContentType("text/html;charset=UTF-8");


        try (
                PreparedStatement preparedStatement = DatabaseUtil.getConnection().prepareStatement(
                        "INSERT INTO Users(firstName, lastName, picfile) VALUES (?, ?, ?)"
                )
        ) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, fileName);

            int row = preparedStatement.executeUpdate();

            resp.getWriter().write(
                    String.format("<p>Upload successfully %d file</p>", row)
            );
        }catch (SQLException  | ClassNotFoundException e){
            e.printStackTrace();
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write(String.format("<p>Error: %s</p>", e.getMessage()));
        }
    }
}
