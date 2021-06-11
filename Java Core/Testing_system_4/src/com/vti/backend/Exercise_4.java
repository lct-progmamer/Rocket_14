package com.vti.backend;

import com.vti.entity.Student;

public class Exercise_4 {
	public void ex4_question1()
	{
		Student student1 = new Student("Lê Nguyên" , "Hà Tĩnh");
		student1.setter_diemtb(5);
		student1.add_diem(1);
		System.out.println(student1.get_point());
		student1.show_infor();
	}
}
