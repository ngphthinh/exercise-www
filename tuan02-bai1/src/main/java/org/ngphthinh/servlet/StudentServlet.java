package org.ngphthinh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ngphthinh.model.Student;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String dateOfBirth = req.getParameter("dob");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pin-code");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String course = req.getParameter("course");
        String[] hobbies = req.getParameterValues("hobbies");

        Student student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .dob(LocalDate.parse(dateOfBirth))
                .mobile(mobile)
                .gender(gender)
                .address(address)
                .city(city)
                .pinCode(pinCode)
                .state(state)
                .country(country)
                .course(course)
                .hobbies(hobbies)
                .build();

        req.setAttribute("student", student);
        req.getRequestDispatcher("student-result.jsp").forward(req, resp);
    }
}
