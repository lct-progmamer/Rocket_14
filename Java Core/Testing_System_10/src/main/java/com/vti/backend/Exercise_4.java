package com.vti.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Exercise_4 {
    public Connection GetConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url,username,password);
    }

    public void deleteDepartmentById(int id) throws SQLException, IOException {
        String sql = "{CALL sp_delete_department( ? )}";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1 , id);
        preparedStatement.executeUpdate();

    }
    public void deleteAccountOfDepartment() throws SQLException, IOException {
        String sql = "DELETE FROM Account WHERE DepartmentId = 3";
        Statement statement = GetConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void ex4_question1() throws SQLException, IOException {
        Connection connection = GetConnection();
        connection.setAutoCommit(false);
        try{
            deleteAccountOfDepartment();
            deleteDepartmentById(3);
            connection.commit();
            System.out.println("Transaction commit");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Transaction rollback");

        }
    }

}
