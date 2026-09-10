package org.ngphthinh.servlet;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ngphthinh.beans.Product;
import org.ngphthinh.dao.ProductDAO;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet({"/products", "/product"})
public class ProductServlet extends HttpServlet {

    @Resource(name = "jdbc/shopdb")
    private DataSource dataSource;

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productDAO.getProductById(id);
            if (product == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
            }
            req.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/product-detail.jsp")
                    .forward(req, resp);
        }


        List<Product> products = productDAO.getAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-list.jsp");
        dispatcher.forward(req, resp);
    }
}
