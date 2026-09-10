package iuh.fit.se.ontap.servlet;

import iuh.fit.se.ontap.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private List<Product> products;

    @Override
    public void init() throws ServletException {
        products = new ArrayList<Product>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("product-name");
        String price = req.getParameter("price");
        String category = req.getParameter("category");
        String available = req.getParameter("is-available");
        String description = req.getParameter("description");
        String expiryDate = req.getParameter("expiry-date");
        Part part = req.getPart("url-img");
        String img = null;
        if (part != null || part.getSize() > 0) {
            File uploads = new File(req.getServletContext().getRealPath("/uploads"));
            if (!uploads.exists()) {
                uploads.mkdir();
            }
            part.write(uploads.getAbsolutePath() + File.separator + part.getSubmittedFileName());
            img = part.getSubmittedFileName();
            System.out.println(img);
        }

        products.add(Product.builder()
                .productName(name)
                .price(Double.parseDouble(price))
                .category(category)
                .isAvailable(available != null && available.equals("true"))
                .urlImg(img)
                .description(description)
                .expiryDate(LocalDate.parse(expiryDate))
                .build());
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
