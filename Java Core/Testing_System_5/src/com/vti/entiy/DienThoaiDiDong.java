package com.vti.entiy;

public abstract class DienThoaiDiDong implements IVuKhi {

    public void Nghe()
    {
        System.out.println("Nghe Dien Thoai");
    }

    public void Goi()
    {
        System.out.println("Goi Dien Thoai");
    }

    public void GuiTinNhan()
    {
        System.out.println("Gui tin nhan");
    }

    public void NhanTinNhan()
    {
        System.out.println("Nhan Tin nhan");
    }

    @Override
    public void tanCongKeThu() {
        System.out.println("Tan cong");

    }
}
