package com.vti.entiy;



public class HinhVuong extends HinhChuNhat{



    public HinhVuong(int a)
    {
        super(a,a);
    }


    @Override
    public int tinhChuVi() {
        System.out.print("Tính chu vi theo Hình Vuông/ Hình Chữ Nhật : ");
        return super.tinhChuVi();
    }

    @Override
    public int tinhDienTich() {
        System.out.print("Tính diện tích theo Hình Vuông/ Hình Chữ Nhật : ");
        return super.tinhDienTich();
    }
}
