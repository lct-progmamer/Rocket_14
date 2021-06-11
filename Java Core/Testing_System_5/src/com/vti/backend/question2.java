package com.vti.backend;
import com.vti.entiy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class question2 {

    public void question2(){
        TuyenSinh tuyensinh = new TuyenSinh();
        Student student1 = new Student("1", "Anh", "Ha Tinh", 1);
        Student student2 = new Student("2", "Binh", "Ha Noi", 2);
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        Menu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số để chọn chương trình : ");
        int ct  =scanner.nextInt();
        switch (ct)
        {
            case 1:
                tuyensinh.add_candidates(students);
                break;
            case 2:
                tuyensinh.find_by_Sbd(students);
                break;
            case 3:
                tuyensinh.show_list_candidates(students);
                break;
            case 4:
                System.out.println("Exits !");
                return;
        }

    }
    public static void Menu(){

        System.out.println("1. Thêm thí sinh");
        System.out.println("2. Hiện thị thông tin thí sinh");
        System.out.println("3. Tìm kiếm theo số báo danh");
        System.out.println("4. Thoát !");
    }

}
