package org.ngphthinh.util;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
public class DBUtil {
    private final DataSource dataSource;

    public Connection getConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
