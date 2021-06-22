package com.vti.backend;



import com.vti.entity.Account;
import com.vti.entity.Department;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class DepartmentDao {
    public Connection GetConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url,username,password);
    }

    public void ex2_question1() throws SQLException, IOException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        Statement statement = GetConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {
            int new_id = resultSet.getInt("ID");
            String new_name = resultSet.getString("NAME");
            departments.add(new Department(new_id , new_name));
        }

        for (Department department: departments) {
            System.out.println(department.toString());
        }



    }

    public void ex2_question2() throws Exception {
        try {
            String sql = "SELECT * FROM Department WHERE ID = 5";
            Statement statement = GetConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("id : " + resultSet.getInt("ID") + " name : " + resultSet.getString("NAME"));
        } catch (Exception e) {
            throw new Exception("Cannot find department which has id = 5");
        }
    }

    public void ex2_question3() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id :  ");
        int id = scanner.nextInt();
        try{
            Department department = getDepartment(id);
            System.out.println(department.toString());
        } catch (Exception e) {
            throw new Exception("Cannot find department which has id = " + id);
        }
    }

    public Department getDepartment(int id) throws Exception {
        Department department = null;
        String sql = "SELECT * FROM Department WHERE ID = ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            department = new Department(resultSet.getInt("ID"), resultSet.getString("NAME"));
        }
        return department;
    }


    public void ex2_question4() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input name of Department : ");
        String name = scanner.nextLine();
        if(isDepartmentNameExists(name))
            System.out.println("Name is exists");
        else
            System.out.println("Name don't exists");
    }

    public boolean isDepartmentNameExists(String name) throws SQLException, IOException {
        String sql = "SELECT * FROM Department WHERE NAME = ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setString(1 , name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return true;
        else
            return false;

    }

    public void ex2_question5() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input new name of department : ");
        String name = scanner.nextLine();
        if(isDepartmentNameExists(name))
            System.out.println("Department Name is Exists!");
        else
            createDepartment(name);
    }

    public void createDepartment(String nameOfDepartment) throws SQLException, IOException {
        String sql = "INSERT INTO Department(`NAME`)" +
                " VALUE ( ? )";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setString(1 , nameOfDepartment);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Affected Rows : " + affectedRows);
    }

    public void ex2_question6() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id of department : ");
        int id  = scanner.nextInt();
        scanner.nextLine();
        if(isDepartmentIdExists(id)) {
            System.out.println("input new name of department : ");
            String name = scanner.nextLine();
            if (!isDepartmentNameExists(name))
                updateDepartmentName(id, name);
            else
                System.out.println("Name is Exists !");
        }
        else
            System.out.println("Cannot find department which has id = " + id);
    }

    public void updateDepartmentName(int id ,String name) throws SQLException, IOException {
        String sql = "UPDATE Department SET NAME = ?    WHERE ID =  ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setString(1 , name);
        preparedStatement.setInt(2 , id);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Affected Rows = "  + affectedRows);
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


    public void ex2_question7() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id : ");
        int id = scanner.nextInt();
        if(isDepartmentIdExists(id))
            deleteDepartment(id);
        else
            System.out.println("Cannot find department which has id = " + id);

    }

    public void deleteDepartment(int id) throws SQLException, IOException {
        String sql = "DELETE FROM Department  WHERE ID = ?";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1 , id);
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Affected Rows : " + affectedRows);
    }


    public void ex2_question8() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input id : ");
        int id = scanner.nextInt();
        getAccountById(id);
    }

    public void getAccountById(int id) throws Exception {
        String sql = "SELECT * FROM Account WHERE ID = ? ";
        PreparedStatement preparedStatement = GetConnection().prepareStatement(sql);
        preparedStatement.setInt(1 , id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Account account = new Account(resultSet.getInt("ID") , resultSet.getString("NAME") , getDepartment(resultSet.getInt("DepartmentID")));
            System.out.println(account.toString());
        }
    }


}
