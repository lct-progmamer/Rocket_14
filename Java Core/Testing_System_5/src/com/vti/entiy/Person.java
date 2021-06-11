package com.vti.entiy;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    private String name;
    private Gender genDer;
    private LocalDate birthDay;
    private String address;


    public Person()
    {

    }

    public Person(String name , Gender gender , LocalDate birthday , String address)
    {
        this.name = name;
        this.genDer = gender;
        this.birthDay = birthday;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGenDer() {
        return genDer;
    }

    public void setGenDer(Gender genDer) {
        this.genDer = genDer;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfor()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input name : ");
        String name = scanner.nextLine();
        this.name = name;
        System.out.println("input gender(MALE ,FEMALE ,UNKNOW) : ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        this.genDer = gender;
        System.out.println("input day : ");
        int day = scanner.nextInt();
        System.out.println("input month : ");
        int month = scanner.nextInt();
        System.out.println("input year  : ");
        int year = scanner.nextInt();
        this.birthDay = LocalDate.of(year , month , day);
        scanner.nextLine();
        System.out.println("input address  : ");
        String address = scanner.nextLine();
        this.address = address;
    }

    public void showInfor()
    {
        System.out.println("Name : " + this.name);
        System.out.println("Gender : " + this.genDer);
        System.out.println("Birthday : "+this.birthDay);
        System.out.println("address : "+this.address);
    }


}
