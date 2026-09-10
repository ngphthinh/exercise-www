package org.ngphthinh.dao;


import org.ngphthinh.beans.Product;
import org.ngphthinh.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT id, model, price, quantity, imgUrl,description FROM products";
        try (
                Connection connection = dbUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                products.add(
                        Product.builder()
                                .id(resultSet.getInt("id"))
                                .model(resultSet.getString("model"))
                                .price(resultSet.getDouble("price"))
                                .quantity(resultSet.getInt("quantity"))
                                .description(resultSet.getString("description"))
                                .imgUrl(resultSet.getString("imgUrl"))
                                .build()
                );
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(int id) {
        String query = "SELECT id, model, price, quantity, imgUrl,description FROM product WHERE id = ?";
        try (
                Connection connection = dbUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Product.builder()
                            .id(resultSet.getInt("id"))
                            .model(resultSet.getString("model"))
                            .price(resultSet.getDouble("price"))
                            .quantity(resultSet.getInt("quantity"))
                            .description(resultSet.getString("description"))
                            .imgUrl(resultSet.getString("imgUrl"))
                            .build();
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
