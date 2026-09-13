package fit.iuh.bai3.servlet;

import fit.iuh.bai3.model.CartBean;
import fit.iuh.bai3.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        if (action != null && action.equals("add")) {
            String id = req.getParameter("id");
            String price = req.getParameter("price");
            String model = req.getParameter("model");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.addToCart(Product.builder()
                    .id(Integer.parseInt(id))
                    .price(Double.parseDouble(price))
                    .model(model)
                    .quantity(quantity)
                    .build());
        } else if (action != null && action.equals("remove")) {
            String id = req.getParameter("productId");
            cart.remove(Integer.parseInt(id));
        } else if (action != null && action.equals("update")) {
            String id = req.getParameter("productId");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.updateQuantity(Integer.parseInt(id), quantity);
        } else if (action != null && action.equals("clear")) {
            cart.clear();
        }

        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);

    }
}
