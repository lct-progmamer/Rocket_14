package com.vti.untils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public  class getconnection {
    public static Connection getConnect() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password =  properties.getProperty("password");
        return  DriverManager.getConnection(url , username , password);
    }
}
