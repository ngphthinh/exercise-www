package fit.iuh.bai3.servlet;

import fit.iuh.bai3.dao.ProductDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {


    private ProductDAO productDAO;

    @Resource(name="jdbc/storedb")
    private DataSource   dataSource;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id != null && !id.isEmpty()) {
            req.setAttribute("product", productDAO.getById(Integer.parseInt(id)));
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("products", productDAO.getAllProduct());
        req.getRequestDispatcher("/product.jsp").forward(req,resp);

    }
}
