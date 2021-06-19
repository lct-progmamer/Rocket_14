package com.vti.backend;
import com.vti.entity.Student;
import java.util.Date;

public class Exercise_1 {

   @SuppressWarnings("deprecation")
    public void question_1()
    {
        Date date = new Date("18/05/2020");
        System.out.println(date);

    }

	public void question_2()
    {
        Student student1 = new Student("Nguyễn Văn A");
        System.out.println(student1.getId());
        System.out.println("name :  " + student1.getName());
    }


}
