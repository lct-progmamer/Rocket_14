package com.vti.entiy;

public class KhoiThi {
    protected int id;
    protected String khoi;

    public KhoiThi(int id)
    {
        this.id = id;
        switch (id)
        {
            case 1 :
                this.khoi = "Khối A : Toán , Lí , Hóa";
                break;
            case 2 :
                this.khoi = "Khối B : Toán , Hóa , Sinh";
                break;
            case 3 :
                this.khoi = "Khối C : Văn , Sử , Địa";
                break;
            default:
                this.khoi = "Không thi đại học ";
                break;
        }
    }


}
