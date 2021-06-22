package com.vti.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Exercise_3 {

    public Connection GetConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url,username,password);
    }

    public boolean isDepartmentIdExists(int id) throws SQLException, IOException {
        String sql = "SELECT * FROM Department WHERE ID = ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1 , id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(!resultSet.next())
            return false;
        else
            return true;
    }

    public void deleteDepartmentById(int id) throws SQLException, IOException {
        String sql = "{CALL sp_delete_department( ? )}";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1 , id);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Affected Rows : " + affectedRows);
    }

    public void ex3_question1() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id  : ");
        int id = scanner.nextInt();
        if(isDepartmentIdExists(id))
            deleteDepartmentById(id);
        else
            System.out.println("Cannot find department which has id = " + id);

    }





}
