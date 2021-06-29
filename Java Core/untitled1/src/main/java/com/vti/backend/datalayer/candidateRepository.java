package com.vti.backend.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import com.vti.entity.GraduationRank;
import com.vti.untils.getconnection;

public class candidateRepository {
    private Connection connection;

    public candidateRepository() throws SQLException, IOException {
        this.connection = getconnection.getConnect();
    }


    public boolean isPhone(String phone) {
        if (phone.length() >= 9 && phone.length() <= 12) {
            int dem = 0;
            for (int i = 0; i < phone.length(); i++) {
                if (phone.charAt(i) >= '0' && phone.charAt(i) <= '9')
                    dem++;
            }
            if (dem == phone.length())
                return true;
            return false;
        }
        return false;
    }

    public boolean isEmail(String email) {
        String vtiEmail = "@vti.com.vn";
        if (email.contains(vtiEmail)) {
            String[] firstEmail = email.split("@", 2);
            int dem = 0, demhoa = 0;
            for (int i = 0; i < firstEmail[0].length(); i++) {
                if ((firstEmail[0].charAt(i) >= 'a' && firstEmail[0].charAt(i) <= 'z') || (firstEmail[0].charAt(i) >= 0 && firstEmail[0].charAt(i) <= 9) || firstEmail[0].charAt(i) == '.') {
                    dem++;
                }
                if (firstEmail[0].charAt(i) >= 'A' && firstEmail[0].charAt(i) <= 'Z')
                    demhoa++;

            }
            if (demhoa <= 1 && dem == firstEmail[0].length() - demhoa)
                return true;
        }
        return false;
    }

    public boolean ExpInYear(int ExpInYear) {
        if (ExpInYear >= 0 && ExpInYear <= 10)
            return true;
        return false;
    }

    public void Register() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ban muon tao tai khoan cho : "
                + "\n1. EXPERIENCECANDIDATE" + "\n2. FRESHERCANDIDATE");
        int select = scanner.nextInt();
        if (select == 1) {
            if (registerCandidate() == 1 && registerExperienceCandidate() == 1)
                System.out.println("Register Success !");
            return;

        } else if (select == 2) {
            if (registerCandidate() == 1 && registerFresherCandidate() == 1)
                System.out.println("Register Success !");
            return;
        }
    }

    public int registerCandidate() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input fisrt name : ");
        String firstname = scanner.nextLine();
        System.out.println("input last name : ");
        String lastname = scanner.nextLine();
        System.out.println("input phone number : ");
        String phone = scanner.nextLine();
        if (!isPhone(phone)) {
            System.out.println("input again !");
            return 0;
        }
        System.out.println("input email : ");
        String email = scanner.nextLine();
        if (!isEmail(email) || isEmailExists(email)) {
            System.out.println("input again");
            return 0;
        }
        System.out.println("input password : ");
        String password = scanner.nextLine();
        if (!isPassword(password)) {
            System.out.println("input again");
            return 0;
        }
        String sql = "INSERT INTO Candidate(FirstName,LastName,Email,Phone,`password`)" +
                "VALUES  (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, phone);
        preparedStatement.setString(5, password);

        int afftectedRows = preparedStatement.executeUpdate();
        return 1;
    }

    public int registerExperienceCandidate() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input ExpInYear : ");
        int expyear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("input proskill : ");
        String proskill = scanner.nextLine();
        String sql = "INSERT INTO ExperienceCandidate(ExpInYear,ProSkill)\n" +
                "VALUES  (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, expyear);
        preparedStatement.setString(2, proskill);

        int AffectedRows = preparedStatement.executeUpdate();
        return AffectedRows;


    }

    public int registerFresherCandidate() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input GraduationRank : " + "\nExcellence" + "\nGood," + "\nFair" +
                "Fair");
        String GraduationRank = scanner.nextLine().toUpperCase();
        String sql = "INSERT INTO FresherCandidate(GraduationRank)" +
                "VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, GraduationRank);
        int afftectedRows = preparedStatement.executeUpdate();
        return afftectedRows;
    }

    public boolean isPassword(String password) {
        if (password.length() >= 6 && password.length() <= 12)
        {
            int dem = 0;
            for(int i=0;i<password.length();i++)
            {
                if(password.charAt(i) >= 'A' && password.charAt(i) <='Z')
                    dem++;
            }

            if(dem >= 1)
                return true;
        }
        return false;

    }

    public void Login() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("|---------Email : ");
        String email = scanner.nextLine();
        if(!isEmail(email) || !isEmailExists(email) )
        {
            System.out.println("Lỗi email ! --> Nhập lại");
            return;
        }
        System.out.println("|---------password : ");
        String password = scanner.nextLine();
        if(!isPassword(password))
        {
            System.out.println("Lỗi password ! --> Nhập lại");
            return;
        }
        String sql = "SELECT * FROM Candidate WHERE Email = ? AND Password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1 , email);
        preparedStatement.setString(2 , password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
        {
            System.out.println("Login success !");
            System.out.println("-----------------------------------");
            return;
        }
        else
        {
            System.out.println("Login faile !");
            System.out.println("-----------------------------------");
            return;
        }

    }

    public boolean isEmailExists(String email) throws SQLException {
        String sql = "SELECT * FROM Candidate WHERE Email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            return true;
        return false;
    }



}
