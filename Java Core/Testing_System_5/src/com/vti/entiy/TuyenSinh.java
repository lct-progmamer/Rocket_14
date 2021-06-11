package com.vti.entiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {


    @Override
    public void add_candidates(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input sbd : ");
        String sbd = scanner.nextLine();
        System.out.println("input name : ");
        String name = scanner.nextLine();
        System.out.println("input address : ");
        String address = scanner.nextLine();
        System.out.println("input muc uu tien : ");
        int mucUuTien = scanner.nextInt();
        Student new_student = new Student(sbd , name , address , mucUuTien);
        students.add(new_student);
        System.out.println("Successfull !");
    }

    @Override
    public void show_list_candidates(List<Student> students) {
        for(Student student : students){
            System.out.println("SBD : " + student.Sbd);
            System.out.println("Name : "+ student.name);
            System.out.println("Address : " + student.address);
            System.out.println("Muu uu tien : " + student.mucUuTien);
        }
    }

    @Override
    public void find_by_Sbd(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input name " );
        String SBD = scanner.nextLine();
        for (Student student: students) {
            if(student.getName().equals(SBD)){
                System.out.println("SBD : " + student.Sbd);
                System.out.println("Name : "+ student.name);
                System.out.println("Address : " + student.address);
                System.out.println("Muu uu tien : " + student.mucUuTien);
            }
        }
    }
}
