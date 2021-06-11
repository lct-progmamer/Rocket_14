package com.vti.entiy;

import java.util.Scanner;

public class Student2 extends Person{
    private String maSv;
    private float diemTb;
    private String email;

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public float getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(float diemTb) {
        this.diemTb = diemTb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void inputInfor() {
        Scanner scanner =  new Scanner(System.in);
        super.inputInfor();
        System.out.println("input Masv : ");
        String masv = scanner.nextLine();
        this.maSv = masv;
        System.out.println("input diem trung binh : ");
        float diem = scanner.nextFloat();
        this.diemTb = diem;
        scanner.nextLine();
        System.out.println("input email : ");
        String email = scanner.nextLine();
        this.email = email;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Ma sv :  " + this.maSv);
        System.out.println("Diem trung binh : " + this.diemTb);
        System.out.println("Email : " + this.email);
        if(this.IsGood())
            System.out.println("Được nhận học bổng");
        else
            System.out.println("Không được nhận");

    }

    public boolean IsGood(){
        if(this.diemTb >= 8.0)
            return true;
        return false;
    }

}
