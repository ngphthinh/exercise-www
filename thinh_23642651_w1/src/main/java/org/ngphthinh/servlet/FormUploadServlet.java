package org.ngphthinh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/processFormUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 1024,
        maxRequestSize = 1024 * 1024 * 15
)
public class FormUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String[] hobbies = req.getParameterValues("hobbies");
        String birthDate = req.getParameter("birth-date");
        Part part = req.getPart("profile-picture");
        String fileName = part.getSubmittedFileName();

        String uploadPath = "D:/Workspace/WWW/exercise/thinh_23642651_w1/uploads";

        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        part.write(file + File.separator + fileName);


        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("<h2>Form Data Received:</h2>");
        resp.getWriter().println("Name: " + name + "<br>");
        resp.getWriter().println("Password: " + password + "<br>");
        resp.getWriter().println("Gender: " + gender + "<br>");
        resp.getWriter().println("Hobbies: " + (hobbies != null ? String.join(", ", hobbies) : "None") + "<br>");
        resp.getWriter().println("Country: " + country + "<br>");
        resp.getWriter().println("Birth Date: " + birthDate + "<br>");
        resp.getWriter().println("Uploaded File: " + (fileName != null ? fileName : "No file") + "<br>");
        resp.getWriter().println("Saved to: " + uploadPath + "<br>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp")
                .forward(req, resp);
    }
}
