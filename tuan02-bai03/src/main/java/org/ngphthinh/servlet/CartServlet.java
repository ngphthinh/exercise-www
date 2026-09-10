package org.ngphthinh.servlet;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ngphthinh.beans.CartBean;
import org.ngphthinh.beans.Product;
import org.ngphthinh.dao.ProductDAO;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Resource(name = "jdbc/shopdb")
    private DataSource dataSource;

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");

        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }
        String action = req.getParameter("action");
        try {
            switch (action) {
                case "add" -> {
                    int id = Integer.parseInt(req.getParameter("id"));
                    Product product = productDAO.getProductById(id);
                    cart.addProduct(product);
                }
                case "remove" -> {
                    int id = Integer.parseInt(req.getParameter("id"));
                    cart.removeProduct(id);
                }
                case "clear" -> {
                    cart.clear();
                }
                case "update" -> {
                    int id = Integer.parseInt(req.getParameter("productId"));
                    int quantity = Integer.parseInt(req.getParameter("quantity"));
                    cart.updateQuantity(id, quantity);
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/cart");

    }
}
