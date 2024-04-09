package com.passaggio.project.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class DatabaseConnection {
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection conn = null;
        try {
            props.load(new FileInputStream("src/main/java/com/passaggio/project/config/connection-info.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("db연결성공");

        } catch (Exception e) {
            System.out.println("db연결실패");
            e.printStackTrace();
        }
        return conn;
    }
}

