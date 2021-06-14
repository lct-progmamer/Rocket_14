package com.vti.backend;

import com.vti.entity.Department;

import java.util.Scanner;

public class Exercise2 {

    public void question_1()
    {
        try{
            float result = devide(7,0);
            System.out.println("result : " + result);
        }
        catch (Exception e)
        {
            System.out.println("cannot devide 0");
        }


    }

    public void question_2(){
        try{
            float result = devide(7,0);
            System.out.println("result : " + result);
        }
        catch (Exception e)
        {
            System.out.println("cannot devide 0");
        }
        finally {
            System.out.println("devide completed!");
        }
    }
    public float devide(int a ,int b)
    {
        return a/b;
    }

    public void question_3()
    {
        try{
          int[] numbers = {1,2,3};
         System.out.println(numbers[10]);
        }
        catch(Exception e) {
            System.out.println("only 3 pt");
        }

    }

    public void question_4() throws Exception
    {
        Department department1 = new Department(1,"sale");
        Department department2 = new Department(2,"marketting");
        Department department3 = new Department(3,"human");
        Department[] departments = new Department[] {department1 , department2 , department3};

        Scanner scanner = new Scanner(System.in);
        System.out.println("input index of Department : ");
        int index = scanner.nextInt();
        if(index < 3)
        {
            departments[index].show();
        }
        else
            throw new Exception("Mảng chỉ gồm 3 phần tử từ [0] -> [2]");
    }
    public int inputAge() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input age : ");
        while(true)
        {
            String age = scanner.nextLine();
            try{
                if(Integer.parseInt(age) < 0)
                    throw new Exception("Wrong inputing! The age must be greater than 0, please input again.");
                else
                    System.out.println( Integer.parseInt(age));
            }
            catch (Exception e) {
                System.out.println("wrong inputing! Please input an age as int, input again.");
            }

        }
    }






}
