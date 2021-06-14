package com.vti.backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ScannerUtils {






    public int inputInt_age(){
        Scanner scanner = new Scanner(System.in);
        {
            System.out.println("input age : ");
            while (true) {
                String age = scanner.nextLine();
                try {
                    return Integer.parseInt(age);
                } catch (Exception e)
                {
                    System.out.println("Nhap lai");
                }
            }
        }
    }
    public Date inputInt_date() {
        Scanner scanner = new Scanner(System.in);
        {
            while (true) {
                try {
                    System.out.println("input day-month-year : ");
                    String dateInput = scanner.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = sdf.parse(dateInput);
                    if(date != null)
                        return date;
                }
                catch (Exception e)
                {
                    System.out.println("Nhap lai");
                }
            }
        }
    }
    public float inputFloat(){
        Scanner scanner = new Scanner(System.in);
        {
            System.out.println("input : ");
            while (true) {
                String number = scanner.nextLine();
                try {
                    return Float.parseFloat(number);
                } catch (Exception e)
                {
                    System.out.println("Nhap lai");
                }
            }
        }
    }
    public Double inputDouble()
    {
        Scanner scanner = new Scanner(System.in);
        {
            System.out.println("input : ");
            while (true) {
                String number = scanner.nextLine();
                try {
                    return Double.parseDouble(number);
                } catch (Exception e)
                {
                    System.out.println("Nhap lai");
                }
            }
        }
    }
    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("input : ");
        String a = scanner.nextLine();
        return a;
    }



    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.input age");
        System.out.println("2.input date");
        System.out.println("3.input float");
        System.out.println("4.input double");
        System.out.println("5.input string");
        System.out.println("6.exit");
        int ct = scanner.nextInt();
        switch (ct)
        {
            case 1 :
                System.out.println(inputInt_age());
                break;
            case 2:
                System.out.println(inputInt_date());
                break;
            case 4:
                System.out.println(inputDouble());
                break;
            case 3:
                System.out.println(inputFloat());
                break;
            case 5:
                System.out.println(inputString());
                break;
            case 6:
                return;
        }
    }



}
