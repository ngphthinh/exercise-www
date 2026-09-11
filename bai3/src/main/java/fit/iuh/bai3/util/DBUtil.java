package fit.iuh.bai3.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil
{
    private DataSource dataSource;

    public DBUtil(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        return  connection;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
