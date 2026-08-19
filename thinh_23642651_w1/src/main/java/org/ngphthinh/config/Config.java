package org.ngphthinh.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("Không tìm thấy config.properties");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Không thể đọc config.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value != null && value.startsWith("${") && value.endsWith("}")) {
            String envKey = value.substring(2, value.length() - 1);
            return System.getenv(envKey);
        }

        return value;
    }
}