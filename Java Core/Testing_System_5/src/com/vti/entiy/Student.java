package com.vti.entiy;

public class Student {
    protected  String Sbd;
    protected String name;
    protected String address;
    protected int mucUuTien;

    public Student(String sbd , String name , String address , int mucUuTien)
    {
        this.Sbd = sbd;
        this.name = name;
        this.address = address;
        this.mucUuTien = mucUuTien;
    }



    public String getSbd() {
        return Sbd;
    }

    public void setSbd(String sbd) {
        Sbd = sbd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMucUuTien() {
        return mucUuTien;
    }

    public void setMucUuTien(int mucUuTien) {
        this.mucUuTien = mucUuTien;
    }
}
