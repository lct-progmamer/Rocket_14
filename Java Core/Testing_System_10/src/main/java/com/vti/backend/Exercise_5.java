package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Exercise_5 {
    private Connection connection;
    public Connection  GetConnection() throws IOException, SQLException {

        if(connection == null || connection.isClosed()){
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/java/database.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url ,username, password);
        }
        return  connection;
    }

    public void question_1() {
        try{
           Connection connection = GetConnection();
            System.out.println("connect success!");
        }
        catch(Exception e)
        {
            System.out.println("faile ! ");
            e.printStackTrace();
        }
    }

    public void disconnect() throws SQLException, IOException {
      if(connection != null && !connection.isClosed())
          connection.close();
    }



}
