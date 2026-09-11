package fit.iuh.bai3.dao;

import fit.iuh.bai3.model.Product;
import fit.iuh.bai3.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO
{
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource){
        dbUtil = new DBUtil(dataSource);
    }

    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Product");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                products.add(Product.builder()
                                .id(resultSet.getInt("id"))
                                .model(resultSet.getString("model"))
                                .price(resultSet.getDouble("price"))
                                .quantity(resultSet.getInt("quantity"))
                                .description(resultSet.getString("description"))

                        .build());
            }
            return products;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
