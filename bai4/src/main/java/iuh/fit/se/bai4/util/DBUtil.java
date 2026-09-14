package iuh.fit.se.bai4.util;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;

@RequiredArgsConstructor
public class DBUtil {

    private final DataSource dataSource;


    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
