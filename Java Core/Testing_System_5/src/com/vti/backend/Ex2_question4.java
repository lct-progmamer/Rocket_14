package com.vti.backend;

import com.vti.entiy.MyMath;

public class Ex2_question4 {


    public void question4()
    {
        MyMath mymath = new MyMath();
        System.out.println("Kieu nguyen : "  + mymath.Sum(5,4));
        System.out.println("Kieu thuc : " + mymath.Sum(1.3f, 5.4f));
        System.out.println("Kieu byte : " +mymath.Sum((byte) 1 , (byte) 5));
    }



}
