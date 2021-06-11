package com.vti.backend;

import com.vti.entiy.DienThoaiCoDien;
import com.vti.entiy.DienThoaiDiDong;
import com.vti.entiy.DienThoaiThongMinh;

public class Ex_question5 {

    public void question5()
    {
        DienThoaiThongMinh dttm = new DienThoaiThongMinh();
        DienThoaiCoDien dtcd = new DienThoaiCoDien();

        System.out.print("Dien thoai thong minh ");
        dttm.ChupHinh();
        dttm.Goi();
        dttm.tanCongKeThu();

        System.out.print("\nDien thoai co dien ");
        dtcd.NgheRadio();
        dtcd.Goi();
        dtcd.tanCongKeThu();


    }

}
