package com.vti.entiy;

public class HinhChuNhat {
    private int cd;
    private int cr;

    public HinhChuNhat(int cd , int cr)
    {
        this.cd = cd;
        this.cr = cr;
    }

    public int tinhDienTich(){
        return cr*cd;
    }

    public int tinhChuVi(){
        return (this.cd + this.cr)*2;
    }



}
