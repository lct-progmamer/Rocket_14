package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Exercise {
   public Connection GetConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url,username,password);
   }

   public void question_1() throws SQLException, IOException {
        try{
            GetConnection();
            System.out.println("connect success!");
        }
        catch(Exception e){
            System.out.println("connect faile!");
        }

    }

   public void question_2() throws SQLException, IOException {

        Statement statement = GetConnection().createStatement();
        String sql = "SELECT * FROM `Position`";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.print("positionId : " + resultSet.getString("ID") + " | ");
            System.out.println("positionName : " + resultSet.getString("NAME"));
        }
    }

   public void ex1_question_3() throws SQLException, IOException {
       String sql = "INSERT INTO `Position`(`NAME`)"
               +  "VALUE( ? )";

       PreparedStatement  preparedStatement = GetConnection().prepareStatement(sql);

       Scanner scanner = new Scanner(System.in);

       System.out.println("Input your position name : ");
       String positionName  = scanner.nextLine();

       preparedStatement.setString(1 , positionName);
       int affectedRows = preparedStatement.executeUpdate();
       System.out.println("affected rows : " + affectedRows);
   }

    public void ex1_question4() throws SQLException, IOException {
        Statement statement = GetConnection().createStatement();
        String sql =  "UPDATE `Position`" +
                "SET `NAME` = 'DEV'" +
                "WHERE ID = 5";
        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affected rows :  " + affectedRows );


    }

    public void ex1_question5() throws SQLException, IOException {
        String sql = "DELETE FROM `Position`" +
                "WHERE ID = ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input delete id : ");
        int id = scanner.nextInt();
        preparedStatement.setInt(1 , id);

        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("affected Rows  :  " + affectedRows);


    }
}
