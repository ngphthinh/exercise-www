package org.ngphthinh.servlet;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ngphthinh.dao.AccountDAO;
import org.ngphthinh.model.Account;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet("/registerform")
public class AccountRegisterServlet extends HttpServlet {
    @Resource(name = "jdbc/storedb")
    private DataSource ds;
    private AccountDAO accountDAO;

    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAO(ds);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        int date = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));

        Account account = Account.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .gender(gender)
                .dateOfBirth(Date.from(LocalDate.of(year, month, date).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        accountDAO.addAccount(account);

        List<Account> accounts = accountDAO.getAllAccounts();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("accounts.jsp").forward(req, resp);

    }
}
