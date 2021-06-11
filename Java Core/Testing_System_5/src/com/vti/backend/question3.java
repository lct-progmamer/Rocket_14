package com.vti.backend;
import com.vti.entiy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class question3 {





    public void question3_b(){
        Student1 student1 = new Student1(1 , "Anh" ,1 );
        Student1 student2 = new Student1(2 , "bình" ,1);
        Student1 student3 = new Student1(3 , "Cát" ,1);
        Student1 student4 = new Student1(4 , "Đạt" ,1);
        Student1 student5 = new Student1(5 ,"Dũng" ,2);
        Student1 student6 = new Student1(6 , "Hoa" ,2);
        Student1 student7 = new Student1(7 , "Hoạt" ,2);
        Student1 student8 = new Student1(8 , "Khánh",3);
        Student1 student9 = new Student1(9 , "Linh" ,3);
        Student1 student10 = new Student1(10 , "Yến" ,3);
        Student1[] student1s = new Student1[] {student1,student2,student3,student4,student5,student6,student7,student8,student9,student10};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhạp số để thực hiện : ");
        System.out.println("1. Cả lớp điểm danh  ");
        System.out.println("2. Gọi nhóm đi học");
        System.out.println("3. Gọi nhóm đi dọn vệ sinh");
        System.out.println("4. Exist");

        int a = scanner.nextInt();
        switch (a)
        {
            case 1:
                question3_diemDanh(student1s);
                break;
            case 2:
                question3_goiDiHoc(student1s);
                break;
            case 3:
                question3_goiDonVeSinh(student1s);
                break;
            case 4:
                return;

        }




    }

    public void question3_diemDanh(Student1[] students)
    {
       for(Student1 student : students)
       {
            student.diemDanh();
       }
    }

    public void question3_goiDiHoc(Student1[] students)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap nhom goi di hoc : ");
        int nhom = scanner.nextInt();
        for(Student1 student : students)
        {
            if(student.getGroup() == nhom)
            {
                student.hocBai();
            }
        }
    }

    public void question3_goiDonVeSinh(Student1[] students)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap nhom goi di don ve sinh  : ");
        int nhom = scanner.nextInt();
        for(Student1 student : students)
        {
            if(student.getGroup() == nhom)
            {
                student.donVeSinh();
            }
        }
    }









}
